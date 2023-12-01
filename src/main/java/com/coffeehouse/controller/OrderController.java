package com.coffeehouse.controller;

import com.coffeehouse.entity.OrderDetail;
import com.coffeehouse.entity.PaymentEntity;
import com.coffeehouse.repository.CartItemRepository;
import com.coffeehouse.repository.OrderRepository;
import com.coffeehouse.repository.PaymentRepository;
import com.coffeehouse.service.CartItemService;
import com.coffeehouse.service.OrderService;
import com.coffeehouse.service.PayPalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("")
public class OrderController {
    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemService cartItemService;

    @Autowired(required = false)
    private PayPalService payPalService;

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/order/paypal")
    public String orderWithPaypal(@RequestParam Long addressId,
                                  @RequestParam(required = false) Long voucherId,
                                  @RequestParam Long userId) {
        String token = "";
        try {
            OrderDetail order = orderService.createOrder(addressId, voucherId, userId);
            System.out.println(order);
            orderRepository.save(order);
            order.setPaymentMethod("paypal");
            Payment payment = payPalService.createPayment(order.getTotal() / 23447, "USD", "paypal",
                    "sale", "thanh toan"
                    , "http://localhost:8080/" + PAYPAL_CANCEL_URL,
                    "http://localhost:8080/" + PAYPAL_SUCCESS_URL);

            PaymentEntity paymentDetails = new PaymentEntity();
            paymentDetails.setId(order.getId());
            paymentDetails.setOrderId(order.getId());
            paymentDetails.setAmount(order.getTotal() / 23447);
            paymentDetails.setPaymentStatus("PENDING");

            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    String[] s = link.getHref().split("=");
                    token = s[2];
                    paymentDetails.setToken(token);
                    paymentRepository.save(paymentDetails);
                    return link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            System.out.println(e);
        }
        return "payment pending";
    }

    @GetMapping(value = PAYPAL_CANCEL_URL)
    public String cancelPay(
            @RequestParam("token") String token
    ) {
        PaymentEntity paymentDetails = paymentRepository.getByToken(token);
        paymentDetails.setPaymentDate(LocalDateTime.now());
        paymentDetails.setPaymentStatus("PAYMENT CANCELLED");
        paymentRepository.save(paymentDetails);

        OrderDetail order = orderRepository.getById(paymentDetails.getOrderId());
        order.setPaymentMethod("PAYPAL");
        order.setStatus("PAYMENT CANCELLED");
        orderRepository.save(order);
        return "payment failed";
    }

    @GetMapping(value = PAYPAL_SUCCESS_URL)
    public String successPay(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("token") String token,
            @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = payPalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                PaymentEntity paymentDetails = paymentRepository.getByToken(token);
                paymentDetails.setPaymentDate(LocalDateTime.now());
                paymentDetails.setPaymentStatus("PAYMENT SUCCESS");
                paymentRepository.save(paymentDetails);

                OrderDetail order = orderRepository.getById(paymentDetails.getOrderId());
                order.setPaymentMethod("PAYPAL");
                order.setStatus("PAYMENT SUCCESS");
                orderRepository.save(order);
                cartItemService.deleteAllByUser(order.getUserId());
                return "payment success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "payment success";
    }

    @PostMapping("/order/cash")
    public String orderWithCash(@RequestParam Long addressId,
                                  @RequestParam(required = false) Long voucherId,
                                  @RequestParam Long userId) {
        OrderDetail order = orderService.createOrder(addressId, voucherId, userId);
        order.setPaymentMethod("cash");
        orderRepository.save(order);
        return "order success";
    }

    @GetMapping("/order/getAllByUser/{id}")
    public List<OrderDetail> getByUserId(@PathVariable("id") Long userId) {
        return orderService.getListOrderOfUser(userId);
    }

    @GetMapping("/order/getById/{id}")
    public OrderDetail getById(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }

    @PatchMapping("/order/rating/{id}")
    public OrderDetail rating(@PathVariable("id") Long id,
                              @RequestParam int rating) {
        return orderService.rating(id, rating);
    }
}

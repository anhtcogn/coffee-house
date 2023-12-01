package com.coffeehouse.service.impl;

import com.coffeehouse.entity.CartItemEntity;
import com.coffeehouse.entity.OrderDetail;
import com.coffeehouse.entity.VoucherEntity;
import com.coffeehouse.repository.CartItemRepository;
import com.coffeehouse.repository.OrderRepository;
import com.coffeehouse.repository.VoucherRepository;
import com.coffeehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public OrderDetail getOrder(Long id) {
        return null;
    }

    @Override
    public List<OrderDetail> getListOrderOfUser(Long userId) {
        return orderRepository.getAllByUserId(userId);
    }

    @Override
    public OrderDetail createOrder(Long addressId, Long voucherId, Long userId) {
        double total = 0;
        double discount = 0;
        List<CartItemEntity> cartList = cartItemRepository.getAllByUserId(userId);
        for (CartItemEntity i:cartList) {
            total += i.getCost();
        }

        if (voucherId != null) {
            VoucherEntity voucher = voucherRepository.findVoucherEntityById(voucherId);
            discount = voucher.getDiscount();
        }

        OrderDetail order = new OrderDetail();
        order.setAddressId(addressId);
        order.setStatus("PENDING");
        order.setUserId(userId);
        order.setVoucherId(voucherId);
        order.setTotal(total - discount);

        return orderRepository.save(order);
    }

    @Override
    public OrderDetail confirmOrder(Long orderId) {
        OrderDetail orderDetail = orderRepository.findOrderDetailById(orderId);
        orderDetail.setStatus("CONFIRM");
        return orderRepository.save(orderDetail);
    }

    @Override
    public OrderDetail cancelOrderByUser(Long orderId) {
        OrderDetail orderDetail = orderRepository.findOrderDetailById(orderId);
        orderDetail.setStatus("CANCEL");
        return orderRepository.save(orderDetail);
    }

    @Override
    public OrderDetail cancelOrderByAd(Long orderId) {
        return null;
    }

    @Override
    public OrderDetail rating(Long orderId, int rating) {
        OrderDetail orderDetail = orderRepository.findOrderDetailById(orderId);
        orderDetail.setRating(rating);
        return orderRepository.save(orderDetail);
    }
}

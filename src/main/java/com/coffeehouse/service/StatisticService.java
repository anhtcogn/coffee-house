package com.coffeehouse.service;

import com.coffeehouse.entity.OrderDetail;
import com.coffeehouse.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {
    @Autowired
    private OrderRepository orderRepository;

    public Map<Integer, Double> statistic() {
        int thisMonth = LocalDateTime.now().getMonthValue();
        Map<Integer, Double> maps = new HashMap<>();
        for (int i = thisMonth - 3; i <= thisMonth; i++) {
            List<OrderDetail> orderDetails = orderRepository.getAllByMonth(i);
            double total = 0;
            for (OrderDetail o:orderDetails) {
                total += o.getTotal();
            }
            maps.put(i, total);
        }
        return maps;
    }
}

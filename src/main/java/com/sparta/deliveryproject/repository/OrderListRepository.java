package com.sparta.deliveryproject.repository;

import com.sparta.deliveryproject.domain.Order;
import com.sparta.deliveryproject.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepository  extends JpaRepository<OrderList, Long> {
    List<OrderList> findAllByOrderMenu(Order orderMenu);
}

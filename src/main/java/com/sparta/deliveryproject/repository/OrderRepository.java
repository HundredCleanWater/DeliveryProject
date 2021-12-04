package com.sparta.deliveryproject.repository;

import com.sparta.deliveryproject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

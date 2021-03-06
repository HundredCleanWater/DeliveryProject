package com.sparta.deliveryproject.dto;

import com.sparta.deliveryproject.domain.Order;
import com.sparta.deliveryproject.domain.OrderList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private String restaurantName;
    private List<OrderListResponseDto>food;
    private int deliveryFee;
    private int totalPrice;


}




package com.sparta.deliveryproject.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {
    private Long restaurantId;
    private List<OrderListRequestDto> food;
}

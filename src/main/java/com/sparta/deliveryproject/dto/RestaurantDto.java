package com.sparta.deliveryproject.dto;


import lombok.*;

@Getter
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
    private Long id;


}
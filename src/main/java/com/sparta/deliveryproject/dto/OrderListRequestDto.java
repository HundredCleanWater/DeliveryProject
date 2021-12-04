package com.sparta.deliveryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderListRequestDto {
    private Long id;
    private String name;
    private int price;
    private int quantity;
}


package com.sparta.deliveryproject.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodRequestDto {
    private Long id;
    private String name;
    private int price;
}

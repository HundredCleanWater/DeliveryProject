package com.sparta.deliveryproject.domain;


import com.sparta.deliveryproject.dto.FoodRequestDto;
import lombok.*;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( nullable = false)
    private Restaurant restaurant;

    public Food(Restaurant restaurant, FoodRequestDto requestDtos) {
        this.restaurant = restaurant;
        this.name = requestDtos.getName();
        this.price = requestDtos.getPrice();
    }

    @Builder
    public Food(Restaurant restaurant, String name, int price){
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
    }
}

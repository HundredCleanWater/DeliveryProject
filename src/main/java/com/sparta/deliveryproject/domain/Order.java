package com.sparta.deliveryproject.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "minOrderPrice")
    private int minOrderPrice;

    @Column(name = "deliveryFee")
    private int deliveryFee;

    @Builder
    public Order(Long id, String name, int minOrderPrice, int deliveryFee) {
        this.id = id;
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;

    }
}

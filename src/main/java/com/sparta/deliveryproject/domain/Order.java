package com.sparta.deliveryproject.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @OneToMany(mappedBy = "orderMenu")
    private List<OrderList> foods = new ArrayList<>();

    public Order(Restaurant restaurant, int totalPrice, int deliveryFee, List<OrderList> food) {
        this.restaurant = restaurant;
        this.totalPrice = totalPrice;
        this.deliveryFee = deliveryFee;
    }


}
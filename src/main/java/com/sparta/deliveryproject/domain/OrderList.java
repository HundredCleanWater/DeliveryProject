package com.sparta.deliveryproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Order orderMenu;

    @Column(nullable = false)
    private int price;

    public OrderList(int quantity, Food food) {
        this.quantity = quantity;
        this.food = food;
    }

    public void setOrderMenu(Order orderMenu) {
        this.orderMenu = orderMenu;
    }
}


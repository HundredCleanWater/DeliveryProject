package com.sparta.deliveryproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.deliveryproject.dto.FoodRequestDto;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @JsonIgnore
    private String name;

    @Column(nullable = false)
    @JsonIgnore
    private int price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;




    @Builder
    public Food(Restaurant restaurant, FoodRequestDto requestDto) {
        this.restaurant = restaurant;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}

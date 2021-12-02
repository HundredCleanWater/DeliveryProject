package com.sparta.deliveryproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.deliveryproject.dto.RestaurantDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonIgnore
    private String name;

    @Column(nullable = false)
    @JsonIgnore
    private int minOrderPrice;

    @JsonIgnore
    @Column(nullable = false)
    private int deliveryFee;


    @Builder
    public Restaurant( String name, int minOrderPrice, int deliveryFee){

        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }

}

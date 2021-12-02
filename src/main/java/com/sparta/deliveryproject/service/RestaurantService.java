package com.sparta.deliveryproject.service;

import com.sparta.deliveryproject.domain.Restaurant;
import com.sparta.deliveryproject.dto.RestaurantDto;
import com.sparta.deliveryproject.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    String errorMessage = "";

    //음식점 등록
    public Restaurant registerRestaurant(RestaurantDto requestDto) {
        String name = requestDto.getName();
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        System.out.println(minOrderPrice);
        if(minOrderPrice < 1000 || minOrderPrice > 100000) {
            errorMessage = "최소주문금액은 1,000원부터 100,000원 입니다.";
            throw new IllegalArgumentException(errorMessage);
        }

        if( minOrderPrice % 100 != 0 ) {
            errorMessage = "주문 가격은 100원단위로만 입력이 가능합니다.";
            throw new IllegalArgumentException(errorMessage);
        }
        if(deliveryFee < 0 || deliveryFee > 10000) {
            errorMessage = "배달비는 0원부터 10,000원 입니다.";
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);

        }

        if( deliveryFee % 500 != 0 ) {
            errorMessage = "배달비는 500원단위로만 입력이 가능합니다.";
            throw new IllegalArgumentException(errorMessage);
        }

        Restaurant restaurant = Restaurant.builder()
                .name(requestDto.getName())
                .minOrderPrice(requestDto.getMinOrderPrice())
                .deliveryFee(requestDto.getDeliveryFee())
                .build();

        return restaurantRepository.save(restaurant);
    }

    //음식점 조회

    public List<Restaurant> serviceGetRestaurantList() {
        return restaurantRepository.findAll();
    }

}

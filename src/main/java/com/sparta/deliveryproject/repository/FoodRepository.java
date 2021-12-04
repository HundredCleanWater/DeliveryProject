package com.sparta.deliveryproject.repository;

import com.sparta.deliveryproject.domain.Food;
import com.sparta.deliveryproject.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findFoodByRestaurantId(Long restaurantId);
    Optional<Food> findByRestaurantIdAndName(Long restarurantId, String name);


}
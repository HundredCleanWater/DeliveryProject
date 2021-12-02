package com.sparta.deliveryproject.repository;

import com.sparta.deliveryproject.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant>findById(Long id);
    Restaurant findByName(String name);

}

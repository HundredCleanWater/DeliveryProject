package com.sparta.deliveryproject.controller;

import com.sparta.deliveryproject.domain.Food;
import com.sparta.deliveryproject.dto.FoodRequestDto;
import com.sparta.deliveryproject.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;


    //음식 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoodList(@PathVariable Long restaurantId) {
        return foodService.findFoodList(restaurantId);
    }

    //음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDtoList) {
        foodService.registerFood(restaurantId, requestDtoList);
    }
}
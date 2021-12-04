package com.sparta.deliveryproject.controller;

import com.sparta.deliveryproject.domain.Food;
import com.sparta.deliveryproject.dto.FoodRequestDto;
import com.sparta.deliveryproject.service.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = {"음식"})
@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;


    //음식 조회
    @ApiOperation(value = "음식 조회")
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoodList(@PathVariable Long restaurantId) {
        return foodService.findFoodList(restaurantId);
    }

    //음식 등록
    @ApiOperation(value = "음식 등록")
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDtos) {
        foodService.registerFood(restaurantId, requestDtos);

//        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
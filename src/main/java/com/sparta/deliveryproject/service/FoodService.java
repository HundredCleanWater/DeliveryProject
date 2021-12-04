package com.sparta.deliveryproject.service;

import com.sparta.deliveryproject.domain.Food;
import com.sparta.deliveryproject.domain.Restaurant;
import com.sparta.deliveryproject.dto.FoodRequestDto;
import com.sparta.deliveryproject.repository.FoodRepository;
import com.sparta.deliveryproject.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    String errorMessage = "";

    @Transactional
    public void registerFood(Long restaurantId, List<FoodRequestDto> requestDtos) {


        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("음식점이 존재하지 않습니다."));


        for (FoodRequestDto requestDto : requestDtos) {
            int price = requestDto.getPrice();


            Optional<Food> found = foodRepository.findByRestaurantIdAndName(restaurantId, requestDto.getName());
            if (found.isPresent()) {
                errorMessage = "동일한 음식명을 사용 할 수 없습니다.";
                throw new IllegalArgumentException(errorMessage);
            }
            if (price < 100 || price > 1000000) {
                errorMessage = "음식 가격은 100원부터 1,000,000원까지 입력이 가능합니다.";
                throw new IllegalArgumentException(errorMessage);
            }
            if (price % 100 != 0) {
                errorMessage = "음식 가격은 100원 단위로만 입력이 가능합니다.";
                throw new IllegalArgumentException(errorMessage);
            }


            Food food = new Food(restaurant, requestDto);
            foodRepository.save(food);

        }
    }

            @Transactional
            public List<Food> findFoodList (Long restaurantId){
                Restaurant restaurant = restaurantRepository.findById(restaurantId)
                        .orElseThrow(
                                () -> new IllegalArgumentException("해당 음식점이 없습니다."));

                return foodRepository.findFoodByRestaurantId(restaurantId);
            }
        }


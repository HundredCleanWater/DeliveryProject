package com.sparta.deliveryproject.controller;


import com.sparta.deliveryproject.domain.Restaurant;
import com.sparta.deliveryproject.dto.RestaurantDto;
import com.sparta.deliveryproject.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




import java.util.List;

@RestController //JSON으로 데이터를 주고받음을 선언
@RequiredArgsConstructor//final로 선언 된 멤버 변수를 자동으로 생성
public class RestaurantController {
    private final RestaurantService restaurantService;


    //음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantList(){
        return restaurantService.serviceGetRestaurantList();

    }

    //음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto requestDto) {
        return restaurantService.registerRestaurant(requestDto);
    }

}

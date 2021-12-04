package com.sparta.deliveryproject.service;

import com.sparta.deliveryproject.domain.Food;
import com.sparta.deliveryproject.domain.Order;
import com.sparta.deliveryproject.domain.OrderList;
import com.sparta.deliveryproject.domain.Restaurant;
import com.sparta.deliveryproject.dto.*;
import com.sparta.deliveryproject.repository.FoodRepository;
import com.sparta.deliveryproject.repository.OrderListRepository;
import com.sparta.deliveryproject.repository.OrderRepository;
import com.sparta.deliveryproject.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderListRepository orderListRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    String errorMessage = "";

    public OrderResponseDto requestOrder(OrderRequestDto RequestDto) {
        Restaurant restaurant = restaurantRepository.findById(RequestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException("음식점이 존재하지 않습니다."));

        List<OrderList> foods = new ArrayList<>();
        List<OrderListResponseDto> foodDto = new ArrayList<>();

        int totalPrice = 0;

        for (OrderListRequestDto orderListRequestDto : RequestDto.getFood()) {
            int quantity = orderListRequestDto.getQuantity();
            if (quantity < 1 || quantity > 100) {
                errorMessage = "수량은 1개 이상 100 개 이하로만 입력이 가능합니다.";
                throw new IllegalArgumentException(errorMessage);
            }

            Food food = foodRepository.findById(orderListRequestDto.getId()).orElseThrow(
                    () -> new IllegalArgumentException("음식을 찾지 못했습니다.")
            );

            OrderListResponseDto orderListResponseDto = new OrderListResponseDto(
                    food.getName(),
                    quantity,
                    food.getPrice() * quantity
            );

            totalPrice += orderListResponseDto.getPrice();
            foods.add(orderListRepository.save(new OrderList(quantity, food)));
            foodDto.add(orderListResponseDto);
        }
        if (totalPrice < restaurant.getMinOrderPrice()) {
            errorMessage = "최소주문금액을 넘지 않았습니다.";
            throw new IllegalArgumentException("errorMessage");
        }
        int deliveryFee = restaurant.getDeliveryFee();
        totalPrice += deliveryFee;

        orderRepository.save(new Order(restaurant, totalPrice, deliveryFee, foods));

        return new OrderResponseDto(
                restaurant.getName(),
                foodDto,
                deliveryFee,
                totalPrice);

    }

    public List<OrderResponseDto> getOrder() {
        return getOrderResponseDto(orderRepository.findAll());
    }

    private List<OrderResponseDto> getOrderResponseDto(List<Order> orderMenuList) {
        List<OrderResponseDto> result = new ArrayList<>();

        for (Order orderMenu : orderMenuList) {
            result.add(new OrderResponseDto(
                    orderMenu.getRestaurant().getName(),
                    getOrderListResponseDto(orderMenu.getFoods()),
                    orderMenu.getDeliveryFee(),
                    orderMenu.getTotalPrice()));
        }
        return result;
    }

    private List<OrderListResponseDto> getOrderListResponseDto(List<OrderList> foods) {
        List<OrderListResponseDto> result = new ArrayList<>();

        for (OrderList orderFood : foods) {
            String foodName = orderFood.getFood().getName();
            int quantity = orderFood.getQuantity();
            int price = quantity * orderFood.getFood().getPrice();

            result.add(new OrderListResponseDto(foodName, quantity, price));
        }

        return result;
    }

}

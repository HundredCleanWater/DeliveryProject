package com.sparta.deliveryproject.controller;

import com.sparta.deliveryproject.dto.OrderRequestDto;
import com.sparta.deliveryproject.dto.OrderResponseDto;
import com.sparta.deliveryproject.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "{주문}")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @ApiOperation(value = "주문 조회")
    @GetMapping("/orders")
    public List<OrderResponseDto> getOrders() {
        return orderService.getOrder();
    }

    @ApiOperation(value = "주문 요청")
    @PostMapping("/order/request")
    public OrderResponseDto requestOrder(@RequestBody OrderRequestDto RequestDto) {
        return orderService.requestOrder(RequestDto);
    }
}

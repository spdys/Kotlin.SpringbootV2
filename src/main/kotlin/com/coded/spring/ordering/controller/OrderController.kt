package com.coded.spring.ordering.controller

import com.coded.spring.ordering.OrderException
import com.coded.spring.ordering.dto.AuthenticationRequest
import com.coded.spring.ordering.dto.FailureResponse
import com.coded.spring.ordering.dto.OrderRequest
import com.coded.spring.ordering.entity.OrderEntity
import com.coded.spring.ordering.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class OrderController(val orderService: OrderService) {

    @GetMapping("/welcome")
    fun welcome() = "Welcome to our Online Ordering Server!"

    @PostMapping("/register")
    fun registerUser(@RequestBody request: AuthenticationRequest) {
        orderService.registerUser(request)
    }

    @GetMapping("/order")
    fun getAll(): List<OrderEntity> {
        return orderService.getAllOrders()
    }

    @PostMapping("/order")
    fun saveOrder(@RequestBody request: OrderRequest): String {
        return orderService.createOrder(request)
    }
}
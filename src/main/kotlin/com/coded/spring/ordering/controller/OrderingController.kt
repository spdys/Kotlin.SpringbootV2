package com.coded.spring.ordering.controller

import com.coded.spring.ordering.dto.OrderRequest
import com.coded.spring.ordering.entity.OrderEntity
import com.coded.spring.ordering.repository.OrderRepository
import org.springframework.web.bind.annotation.*

@RestController
class OrderingController(val orderRepository: OrderRepository) {

    @GetMapping("/welcome")
    fun welcome() = "Welcome to our Online Ordering Server!"


    @GetMapping("/order")
    fun getAll(): List<OrderEntity> {
        return orderRepository.findAll()
    }

    @PostMapping("/order")
    fun saveOrder(@RequestBody request: OrderRequest): String {
        val order = OrderEntity(
            request.id,
            request.userId,
            request.restaurant,
            request.items.joinToString(", ")
        )
        orderRepository.save(order)
        return "Order created."
    }
}
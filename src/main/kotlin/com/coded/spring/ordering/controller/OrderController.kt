package com.coded.spring.ordering.controller

import com.coded.spring.ordering.dto.OrderRequest
import com.coded.spring.ordering.entity.OrderEntity
import com.coded.spring.ordering.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
class OrderController(val orderService: OrderService) {

    @GetMapping("/welcome")
    fun welcome() = "Welcome to our Online Ordering Server!"


    @GetMapping("/order")
    fun getAll(): Map<String, List<OrderEntity>> {
        val orders = orderService.getAllOrders()
        return mapOf("orders" to orders)
    }

    @PostMapping("/order")
    fun saveOrder(@RequestBody request: OrderRequest): String {
        return orderService.createOrder(request)
    }
}
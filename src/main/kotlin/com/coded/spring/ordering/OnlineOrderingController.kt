package com.example.onlineOrdering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class OnlineOrderingController {

    val orderDatabase = mutableListOf<Order>()

    @GetMapping("/welcome")
    fun welcome() = "Welcome to our Online Ordering Server!"


    @PostMapping("/order")
    fun saveOrder(@RequestBody order: Order): String {
        orderDatabase.add(order)
        return "Order created."
    }

    @GetMapping("/order")
    fun getAll():
            List<Order> = orderDatabase.sortedBy {
                it.createdAt
            }

    data class Order(
        val user: String,
        val restaurant: String,
        val items: List<String>,
        val createdAt: LocalDateTime = LocalDateTime.now()
    )
}


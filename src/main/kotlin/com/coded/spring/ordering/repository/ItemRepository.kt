package com.coded.spring.ordering.repository

import com.coded.spring.ordering.entity.ItemEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<ItemEntity, Long> {
    fun findByName(name: String): ItemEntity?
}
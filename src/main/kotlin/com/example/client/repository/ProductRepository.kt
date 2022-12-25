package com.example.client.repository

import com.example.client.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository:JpaRepository<Product, Long> {

    fun findById(id: Long?): Product
}


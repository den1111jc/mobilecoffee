package com.example.mycoffee.domain.repository

import androidx.lifecycle.LiveData
import com.example.mycoffee.data.models.OrderLocalModel

interface OrderLocalCall {
    suspend fun insert(orderLocalModel: OrderLocalModel)
    fun loadOrder(): LiveData<List<OrderLocalModel>>
    suspend fun clear()
}
package com.example.mycoffee.domain.useCase

import androidx.lifecycle.LiveData
import com.example.mycoffee.data.models.OrderLocalModel
import com.example.mycoffee.domain.repository.OrderLocalCall

class OrderLocalUseCase (private val orderLocalCall: OrderLocalCall) {


    suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalCall.insert(orderLocalModel)    }

    fun loadOrder(): LiveData<List<OrderLocalModel>> {
        return orderLocalCall.loadOrder()    }

    suspend fun clear() {
        orderLocalCall.clear()    }

}
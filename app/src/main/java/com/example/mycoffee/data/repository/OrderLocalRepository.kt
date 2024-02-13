package com.example.mycoffee.data.repository

import androidx.lifecycle.LiveData
import com.example.mycoffee.data.localDB.OrderLocalDao
import com.example.mycoffee.data.models.OrderLocalModel
import com.example.mycoffee.domain.repository.OrderLocalCall

class OrderLocalRepository (private val orderLocalDao: OrderLocalDao
): OrderLocalCall {

    override suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalDao.insert(orderLocalModel)    }

    override fun loadOrder(): LiveData<List<OrderLocalModel>> {
        return orderLocalDao.loadOrder()    }

    override suspend fun clear() {
        orderLocalDao.clear()    }



}
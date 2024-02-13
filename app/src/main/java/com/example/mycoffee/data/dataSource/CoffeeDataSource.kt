package com.example.mycoffee.data.dataSource

import androidx.lifecycle.LiveData
import com.example.mycoffee.data.models.CoffeeModel

interface CoffeeDataSource {
    fun insert(coffeeModel: CoffeeModel)
    fun loadCoffee(): LiveData<List<CoffeeModel>>
    suspend fun clear()
}
package com.example.mycoffee.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mycoffee.data.dataSource.CoffeeApiDataSource
import com.example.mycoffee.data.dataSource.CoffeeDataSource
import com.example.mycoffee.data.models.CoffeeModel
import com.example.mycoffee.domain.repository.CoffeeCall

class CoffeeRepository (private val coffeeApiDataSource: CoffeeApiDataSource,
                        private val coffeeDataSource: CoffeeDataSource
): CoffeeCall {

    //val products = dao.loadCoffee()

    override fun loadCoffee(): LiveData<List<CoffeeModel>> {
        return coffeeDataSource.loadCoffee()    }



    override suspend fun startMigration(context: Context) {
        coffeeDataSource.clear()
        coffeeApiDataSource.startMigration(context)
    }



}

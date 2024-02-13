package com.example.mycoffee.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mycoffee.data.models.CoffeeModel

interface CoffeeCall {
    fun loadCoffee(): LiveData<List<CoffeeModel>>
    suspend fun startMigration(context: Context)
}
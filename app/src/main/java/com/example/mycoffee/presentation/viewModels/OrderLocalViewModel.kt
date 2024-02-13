package com.example.mycoffee.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycoffee.data.models.CardModel
import com.example.mycoffee.data.models.OrderLocalModel
import com.example.mycoffee.domain.useCase.CardUseCase
import com.example.mycoffee.domain.useCase.OrderLocalUseCase
import kotlinx.coroutines.launch

class OrderLocalViewModel (private val orderLocalUseCase: OrderLocalUseCase): ViewModel() {


    fun startInsert(nameUser:String, phoneUser:String, description:String, totalPrice:String) {
        insert(
            OrderLocalModel(0, nameUser, phoneUser, description, totalPrice)
        )
    }

    private fun insert(orderLocalModel: OrderLocalModel) = viewModelScope.launch{

        orderLocalUseCase.insert(orderLocalModel)
    }

    val loadOrder = orderLocalUseCase.loadOrder()

    fun clearOrders() = viewModelScope.launch{

        orderLocalUseCase.clear()
    }



}
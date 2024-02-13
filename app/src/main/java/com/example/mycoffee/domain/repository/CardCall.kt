package com.example.mycoffee.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mycoffee.data.models.CardModel
import com.example.mycoffee.data.models.CoffeeModel

interface CardCall {

    suspend fun insert(cardModel: CardModel)

    suspend fun updateProductToCard(cardModel: CardModel)

    fun loadCoffeeFromCard(): LiveData<List<CardModel>>

    fun loadCoffeeToCardFromCardProduct(idProduct:String): LiveData<List<CardModel>>

    suspend fun deleteProductFromCard(idProduct:Int)

    suspend fun deleteProductToCardFromCardProduct(idProduct:String)

    suspend fun clear()

}
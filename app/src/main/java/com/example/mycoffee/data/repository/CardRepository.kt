package com.example.mycoffee.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycoffee.data.dataSource.CoffeeApiDataSource
import com.example.mycoffee.data.dataSource.CoffeeDataSource
import com.example.mycoffee.data.localDB.CardDao
import com.example.mycoffee.data.models.CardModel
import com.example.mycoffee.data.models.CoffeeModel
import com.example.mycoffee.domain.repository.CardCall
import com.example.mycoffee.domain.repository.CoffeeCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardRepository (private val dao: CardDao): CardCall {

    //val products = dao.loadCoffee()

    override suspend fun insert(cardModel: CardModel) {
        dao.insert(cardModel)    }

    override suspend fun updateProductToCard(cardModel: CardModel){
        dao.updateProductToCard(cardModel)
    }

    override fun loadCoffeeFromCard(): LiveData<List<CardModel>> {
        return dao.loadCoffeeFromCard()    }

    override fun loadCoffeeToCardFromCardProduct(idProduct:String): LiveData<List<CardModel>> {
        return dao.loadCoffeeToCardFromCardProduct(idProduct)    }

    override suspend fun deleteProductFromCard(idProduct:Int) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteProductFromCard(idProduct)}
    }

    override suspend fun deleteProductToCardFromCardProduct(idProduct:String) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteProductToCardFromCardProduct(idProduct)}
    }

    override suspend fun clear() {
        dao.clear()    }







}

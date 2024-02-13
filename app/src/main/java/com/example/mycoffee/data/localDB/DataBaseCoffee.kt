package com.example.mycoffee.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycoffee.data.models.CardModel
import com.example.mycoffee.data.models.CoffeeModel
import com.example.mycoffee.data.models.OrderLocalModel

@Database(entities = [CardModel::class, CoffeeModel::class, OrderLocalModel::class], version = 1)
abstract class DataBaseCoffee: RoomDatabase() {
    abstract val cardDao: CardDao
    abstract val coffeeDao: CoffeeDao
    abstract val orderLocalDao: OrderLocalDao

}
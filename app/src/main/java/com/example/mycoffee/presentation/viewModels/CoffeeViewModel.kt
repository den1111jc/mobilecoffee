package com.example.mycoffee.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycoffee.domain.useCase.CoffeeUseCase
import kotlinx.coroutines.launch

class CoffeeViewModel (private val coffeeUseCase: CoffeeUseCase): ViewModel() {

    val loadCoffee = coffeeUseCase.loadCoffee()


    fun migration(context: Context) = viewModelScope.launch {
        coffeeUseCase.startMigration(context)

    }

}
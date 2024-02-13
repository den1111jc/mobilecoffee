package com.example.mycoffee.presentation.di

import androidx.room.Room
import com.example.mycoffee.data.dataSource.CoffeeApiDataSource
import com.example.mycoffee.data.dataSource.CoffeeDataSource
import com.example.mycoffee.data.dataSourceIMPL.CoffeeApiDataSourceIMPL
import com.example.mycoffee.data.dataSourceIMPL.CoffeeDataSourceIMPL
import com.example.mycoffee.data.localDB.DataBaseCoffee
import com.example.mycoffee.data.repository.CardRepository
import com.example.mycoffee.data.repository.CoffeeRepository
import com.example.mycoffee.data.repository.OrderApiRepository
import com.example.mycoffee.data.repository.OrderLocalRepository
import com.example.mycoffee.domain.repository.CardCall
import com.example.mycoffee.domain.repository.CoffeeCall
import com.example.mycoffee.domain.repository.OrderApiCall
import com.example.mycoffee.domain.repository.OrderLocalCall
import com.example.mycoffee.domain.useCase.CardUseCase
import com.example.mycoffee.domain.useCase.CoffeeUseCase
import com.example.mycoffee.domain.useCase.OrderApiUseCase
import com.example.mycoffee.domain.useCase.OrderLocalUseCase
import com.example.mycoffee.presentation.viewModels.CardViewModel
import com.example.mycoffee.presentation.viewModels.CoffeeViewModel
import com.example.mycoffee.presentation.viewModels.OrderApiViewModel
import com.example.mycoffee.presentation.viewModels.OrderLocalViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coffee = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "dbC").build()
    }

    single { get<DataBaseCoffee>().coffeeDao }


    single<CoffeeDataSource> {
        CoffeeDataSourceIMPL(
            get()
        )
    }

    single<CoffeeApiDataSource> {
        CoffeeApiDataSourceIMPL(
            get()
        )
    }

    single<CoffeeCall> { CoffeeRepository(get(),get()) }

    single { CoffeeUseCase(get()) }

    viewModel { CoffeeViewModel(get()) }

}

val card = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "dbO").build()
    }

    single { get<DataBaseCoffee>().cardDao }


    single<CardCall> { CardRepository(get()) }

    single { CardUseCase(get()) }

    viewModel { CardViewModel(get()) }

}

val order = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "dbS").build()
    }

    single { get<DataBaseCoffee>().orderLocalDao }


    single<OrderLocalCall> { OrderLocalRepository(get()) }

    single { OrderLocalUseCase(get()) }

    viewModel { OrderLocalViewModel(get()) }

}

val orderApi= module{

    single<OrderApiCall> { OrderApiRepository() }

    single { OrderApiUseCase(get()) }

    viewModel { OrderApiViewModel(get()) }

}

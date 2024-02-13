package com.example.mycoffee.data.dataSource

import android.content.Context

interface CoffeeApiDataSource {
    fun startMigration (context: Context)
}
package com.example.bmicalculator

import android.app.Application
import androidx.room.Room
import com.example.bmicalculator.db.BMIDB

class MainApplication : Application() {

    companion object {
        lateinit var bmiDB: BMIDB
    }

    override fun onCreate() {
        super.onCreate()

        bmiDB = Room.databaseBuilder(
            applicationContext,
            klass = BMIDB::class.java,
            name = BMIDB.bmiDBName
        ).build()
    }

}
package com.example.eduard.roomtest

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase

@Database(entities = [(MyData::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myDataDao(): MyDataDao

    companion object {
        private const val DATABASE_NAME = "room_database"

        fun create(): AppDatabase {
            return Room
                .databaseBuilder(MyApp.getAppContext(), AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}
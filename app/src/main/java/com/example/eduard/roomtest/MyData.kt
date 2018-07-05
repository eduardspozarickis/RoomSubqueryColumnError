package com.example.eduard.roomtest

import android.arch.persistence.room.Entity

@Entity(tableName = "myDatas", primaryKeys = ["dataId", "key"])
class MyData {
    lateinit var dataId: String
    lateinit var key: String
    lateinit var message: String
    var priority: Int = 0

    companion object {
        fun create(collectionId: String, key: String, message: String) :MyData {
            val data = MyData()
            data.dataId = collectionId
            data.key = key
            data.message = message
            return data
        }
    }
}
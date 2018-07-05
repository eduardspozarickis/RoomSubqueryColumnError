package com.example.eduard.roomtest

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface MyDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun put(data: MyData)

    @Query(
        """
        SELECT `key`, message
        FROM (
            SELECT *
            FROM myDatas
            WHERE dataId == :dataId
            GROUP BY `key`
        )
        WHERE `key` LIKE :filter
        ORDER BY priority
        """
    )
    fun getList(dataId: String, filter: String): List<MainActivity.MyDataModel>

    @Query(
        """
        SELECT `key`, message
        FROM (
            SELECT * FROM (
                SELECT *
                FROM myDatas
                WHERE dataId == :dataId
                ORDER BY priority
            )
            GROUP BY `key`
        )
        WHERE `key` LIKE :filter
        ORDER BY `key`
        """
    )
    fun getListOrig(dataId: String, filter: String): List<MainActivity.MyDataModel>
}
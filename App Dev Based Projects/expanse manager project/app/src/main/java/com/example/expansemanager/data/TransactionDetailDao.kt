package com.example.expansemanager.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TransactionDetailDao {

    @Query("SELECT*FROM `transaction` WHERE `id`=:id")
    fun getTransaction(id: Long): LiveData<Transaction>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transaction: Transaction): Long

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
}
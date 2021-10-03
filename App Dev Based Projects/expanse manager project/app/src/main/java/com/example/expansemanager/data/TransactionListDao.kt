package com.example.expansemanager.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query


@Dao
interface TransactionListDao {

    @Query("SELECT * FROM `transaction` WHERE date=:date")
    fun getTransactionByDate(date: String): LiveData<List<Transaction>>

    @Query("Select * from `transaction` WHERE  date >= date('now') order by date ASC")
    fun getAllTransaction(): LiveData<List<Transaction>>

    @Query("SELECT Sum(amount) FROM `transaction`")
    fun getAmount(): LiveData<Float>

    @Query("SELECT Sum(amount) FROM `transaction` WHERE type = 0 ")
    fun getSumCash(): LiveData<Float>

    @Query("SELECT Sum(amount) FROM `transaction` WHERE type = 1")
    fun getSumCredit(): LiveData<Float>

    @Query("SELECT Sum(amount) FROM `transaction` WHERE type = 2")
    fun getSumDebit(): LiveData<Float>


    @Query("SELECT t1.monthYear, t1.month, t1.year, SUM(t1.amount) as sum,(SELECT t2.name FROM `transaction` as t2 WHERE t1.monthYear = t2.monthYear LIMIT 3) as expense FROM `transaction` as t1 GROUP BY monthYear ORDER BY year, month")
    fun getTransactionMonth(): LiveData<List<MonthlyTransactions>>


    @Query("SELECT * FROM `transaction` WHERE monthYear = :monthYear ORDER BY id")
    fun getTransactionMonth(monthYear: Long): LiveData<List<Transaction>>

    @Query("SELECT SUM(amount) FROM `transaction` WHERE monthYear = :monthYear")
    fun getSumMonth(monthYear: Long): LiveData<Float>

    @Query("SELECT name,amount,date FROM `transaction` WHERE date = :date")
    fun getAmountMonth(date: String): LiveData<List<Expense>>

}
package com.example.expansemanager.data

import android.app.Application
import androidx.lifecycle.LiveData


class TransactionListRepository(context: Application) {
    private val transactionListDao: TransactionListDao =
        TransactionDatabase.getDatabase(context).transactionListDao()

    fun getTransactions(): LiveData<List<Transaction>> {
        return transactionListDao.getAllTransaction()
    }

    fun getAmount(): LiveData<Float> {
        return transactionListDao.getAmount()
    }

    fun getTransactionByDate(date: String): LiveData<List<Transaction>> {
        return transactionListDao.getTransactionByDate(date)
    }

    fun getAmountCash(): LiveData<Float> {
        return transactionListDao.getSumCash()
    }

    fun getAmountCredit(): LiveData<Float> {
        return transactionListDao.getSumCredit()
    }

    fun getAmountDebit(): LiveData<Float> {
        return transactionListDao.getSumDebit()
    }

    fun getTransactionMonth(): LiveData<List<MonthlyTransactions>> {
        return transactionListDao.getTransactionMonth()
    }

    fun getTransactionMonth(monthYear: Long): LiveData<List<Transaction>> {
        return transactionListDao.getTransactionMonth(monthYear)
    }

    fun getSumMonth(monthYear: Long): LiveData<Float> {
        return transactionListDao.getSumMonth(monthYear)
    }

    fun getAmountMonth(date: String): LiveData<List<Expense>> {
        return transactionListDao.getAmountMonth(date)
    }
}

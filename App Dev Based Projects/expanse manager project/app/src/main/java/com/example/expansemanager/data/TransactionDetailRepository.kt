package com.example.expansemanager.data

import android.app.Application
import androidx.lifecycle.LiveData


class TransactionDetailRepository(context: Application) {
    private val transactionDetailDao: TransactionDetailDao =
        TransactionDatabase.getDatabase(context).transactionDetailDao()

    fun getTransaction(id: Long): LiveData<Transaction> {
        return transactionDetailDao.getTransaction(id)
    }

    suspend fun insertTransaction(transaction: Transaction): Long {
        return transactionDetailDao.insertTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction) {
        transactionDetailDao.deleteTransaction(transaction)
    }

    suspend fun updateTransaction(transaction: Transaction) {
        transactionDetailDao.updateTransaction(transaction)
    }
}
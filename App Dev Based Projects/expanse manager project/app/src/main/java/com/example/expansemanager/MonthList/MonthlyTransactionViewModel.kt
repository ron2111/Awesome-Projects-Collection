package com.example.expansemanager.MonthList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.expansemanager.data.MonthlyTransactions
import com.example.expansemanager.data.TransactionListRepository

class MonthlyTransactionViewModel(application: Application): AndroidViewModel(application) {

    private val repo: TransactionListRepository = TransactionListRepository(application)

    val month: LiveData<List<MonthlyTransactions>>
        get() = repo.getTransactionMonth()

}
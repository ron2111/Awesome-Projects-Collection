package com.example.expansemanager.UpcomingTransactions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.expansemanager.data.Transaction
import com.example.expansemanager.data.TransactionListRepository

class TransactionListViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: TransactionListRepository = TransactionListRepository(application)

    val transactions: LiveData<List<Transaction>>
        get() = repo.getTransactions()

    val netAmount: LiveData<Float>
        get() = repo.getAmount()

    val netAmountCash: LiveData<Float>
        get() = repo.getAmountCash()

    val netAmountCredit: LiveData<Float>
        get() = repo.getAmountCredit()

    val netAmountDebit: LiveData<Float>
        get() = repo.getAmountDebit()


}

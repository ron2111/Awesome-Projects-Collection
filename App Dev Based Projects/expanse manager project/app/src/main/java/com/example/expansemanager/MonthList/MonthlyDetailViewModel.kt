package com.example.expansemanager.MonthList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.expansemanager.data.Expense
import com.example.expansemanager.data.Transaction
import com.example.expansemanager.data.TransactionListRepository

class MonthlyDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: TransactionListRepository = TransactionListRepository(application)

    private val _transactionMonthYear = MutableLiveData<Long>(0)
    private val _date = MutableLiveData<String>()

    val transactionMonth: LiveData<List<Transaction>> =
        Transformations.switchMap(_transactionMonthYear) { id ->
            repo.getTransactionMonth(id)
        }
    val sumByMonth: LiveData<Float> = Transformations.switchMap(_transactionMonthYear) { id ->
        repo.getSumMonth(id)
    }
    val amountByMonth: LiveData<List<Expense>> = Transformations.switchMap(_date) { id ->
        repo.getAmountMonth(id)
    }

    fun setMonthYear(monthYear: Long) {
        _transactionMonthYear.value = monthYear
    }

    fun setDate(date: String) {
        _date.value = date
    }
}
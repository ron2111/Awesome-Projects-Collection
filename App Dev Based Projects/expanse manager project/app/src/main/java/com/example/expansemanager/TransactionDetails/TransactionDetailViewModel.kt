package com.example.expansemanager.TransactionDetails
import android.app.Application
import androidx.lifecycle.*
import com.example.expansemanager.data.Transaction
import com.example.expansemanager.data.TransactionDetailRepository
import kotlinx.coroutines.launch

class TransactionDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: TransactionDetailRepository =
        TransactionDetailRepository(application)

    private val _transactionId = MutableLiveData<Long>(0)

    val transactionId: LiveData<Long>
        get() = _transactionId

    val transaction: LiveData<Transaction> = Transformations
        .switchMap(_transactionId) { id ->
            repo.getTransaction(id)
        }

    fun setTransactionId(id: Long) {
        if (_transactionId.value != id) {
            _transactionId.value = id
        }
    }

    fun saveTransaction(transaction: Transaction) {
        viewModelScope.launch {
            if (_transactionId.value == 0L) {
                _transactionId.value = repo.insertTransaction(transaction)
            } else {
                repo.updateTransaction(transaction)
            }
        }
    }

    fun deleteTransaction() {
        viewModelScope.launch {
            transaction.value?.let { repo.deleteTransaction(it) }
        }
    }
}
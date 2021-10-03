package com.example.expansemanager.TransactionDetails
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.expansemanager.R
import com.example.expansemanager.data.Transaction
import com.example.expansemanager.data.TransactionType
import kotlinx.android.synthetic.main.fragment_transaction_detail.*
import java.text.SimpleDateFormat
import java.util.*

class TransactionDetailFragment : Fragment() {

    private lateinit var viewModel: TransactionDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TransactionDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        return inflater.inflate(R.layout.fragment_transaction_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        
        dateselectid.editText?.transformIntoDatePicker(requireContext(), "yyyy-MM-dd")
        dateselectid.editText?.transformIntoDatePicker(requireContext(), "yyyy-MM-dd", Date())

        fromdateid.editText?.transformIntoDatePicker(requireContext(), "yyyy-MM-dd")
        fromdateid.editText?.transformIntoDatePicker(requireContext(), "yyyy-MM-dd", Date())

        todateid.editText?.transformIntoDatePicker(requireContext(), "yyyy-MM-dd")
        todateid.editText?.transformIntoDatePicker(requireContext(), "yyyy-MM-dd", Date())

        fromdateid.isEnabled = false
        todateid.isEnabled = false
        recurring_transactionid.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                fromdateid.isEnabled = true
                todateid.isEnabled = true
            } else {
                fromdateid.isEnabled = false
                todateid.isEnabled = false
                fromdateid.editText?.setText("")
                todateid.editText?.setText("")

            }
        }


        val properties = mutableListOf<String>()
        TransactionType.values().forEach { properties.add(it.name) }

        val arrayAdapter =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, properties)
        _typeid.adapter = arrayAdapter

        _typeid?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long,
            ) {
            }
        }

        val id = TransactionDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel.setTransactionId(id)

   
        if (id != 0L)
            disableFields()

        viewModel.transaction.observe(viewLifecycleOwner, Observer {
            it?.let { setData(it) }
        })

        incomeid.setOnClickListener {
            saveTransactionIncome()
        }

        expenseid.setOnClickListener {
            saveTransactionExpanse()
        }

        addappBar10.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {

                R.id.delete -> {
                    deleteTransaction()
                    true
                }

                R.id.edit_pen -> {
                    enableFields()
                    incomeid.setOnClickListener {
                        saveTransactionIncome()
                    }

                    expenseid.setOnClickListener {
                        saveTransactionExpanse()
                    }
                    true
                }
                else -> false
            }
        }
    }

    private fun deleteTransaction() {
        viewModel.deleteTransaction()


        this.requireActivity().onBackPressed()
    }

    private fun setData(transaction: Transaction) {
        TransactionNameid.editText?.setText(transaction.name)
        etamountid.editText?.setText(transaction.amount.toString())
        dateselectid.editText?.setText(transaction.date)
        fromdateid.editText?.setText(transaction.fromDate)
        todateid.editText?.setText(transaction.toDate)
        selectcategoryid.text = transaction.category
        commentid.editText?.setText(transaction.comment)
        _typeid.setSelection(transaction.type)
    }

    private fun saveTransactionIncome() {
        val transactionName = TransactionNameid.editText?.text.toString()
        val amount = etamountid.editText?.text.toString()
        val selectDate = dateselectid.editText?.text.toString()
        val fromDate = fromdateid.editText?.text.toString()
        val toDate = todateid.editText?.text.toString()
        val type = _typeid.selectedItemPosition
        val category = selectcategoryid.text.toString()
        val comment = commentid.editText?.text.toString()

        val transaction = Transaction(
            viewModel.transactionId.value!!,
            transactionName,
            amount.toFloat(),
            selectDate,
            fromDate,
            toDate,
            (selectDate.substring(0, 4) + selectDate.substring(5, 7)).toLong(),
            selectDate.substring(5, 7).toInt(),
            selectDate.substring(0, 4).toInt(),
            category,
            type,
            comment,
            1
        )
        viewModel.saveTransaction(transaction)
        this.requireActivity().onBackPressed()


    }

    private fun saveTransactionExpanse() {
        val transactionName = TransactionNameid.editText?.text.toString()
        val amount = etamountid.editText?.text.toString()
        val selectDate = dateselectid.editText?.text.toString()
        val fromDate = fromdateid.editText?.text.toString()
        val toDate = todateid.editText?.text.toString()
        val type = _typeid.selectedItemPosition
        val category = selectcategoryid.text.toString()
        val comment = commentid.editText?.text.toString()

        val vary: Float = amount.toFloat() * (-1)
        val transaction = Transaction(
            viewModel.transactionId.value!!,
            transactionName,
            vary,
            selectDate,
            fromDate,
            toDate,
            (selectDate.substring(0, 4) + selectDate.substring(5, 7)).toLong(),
            selectDate.substring(5, 7).toInt(),
            selectDate.substring(0, 4).toInt(),
            category,
            type,
            comment,
            0
        )

        viewModel.saveTransaction(transaction)
        this.requireActivity().onBackPressed()
    }

    private fun enableFields() {
        TransactionNameid.isEnabled = true
        etamountid.isEnabled = true
        dateselectid.isEnabled = true
        fromdateid.isEnabled = true
        todateid.isEnabled = true
        _typeid.isEnabled = true
        transactiontypeid.isEnabled = true
        commentid.isEnabled = true
        expenseid.isEnabled = true
        incomeid.isEnabled = true
    }

    private fun disableFields() {
        TransactionNameid.isEnabled = false
        etamountid.isEnabled = false
        dateselectid.isEnabled = false
        fromdateid.isEnabled = false
        todateid.isEnabled = false
        _typeid.isEnabled = false
        transactiontypeid.isEnabled = false
        commentid.isEnabled = false
        expenseid.isEnabled = false
        incomeid.isEnabled = false

    }

    fun EditText.transformIntoDatePicker(context: Context, format: String, maxDate: Date? = null) {
        isFocusableInTouchMode = false
        isClickable = true
        isFocusable = false

        val myCalendar = Calendar.getInstance()
        val datePickerOnDataSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, monthOfYear)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val sdf = SimpleDateFormat(format, Locale.UK)
                setText(sdf.format(myCalendar.time))
            }

        setOnClickListener {
            DatePickerDialog(
                context, datePickerOnDataSetListener, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).run {

                show()
            }
        }
    }
}
package com.example.expansemanager.loginandsave

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expansemanager.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        sharedPreferences =
            this.requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)

        val boarded: Boolean = sharedPreferences.getBoolean("isLogin", false)

        if (boarded) {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToTransactionListFragment()
            )
        } else {
            sharedPreferences.edit().putBoolean("isLogin", true)
        }
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PersonNameid.editText?.addTextChangedListener(boardingTextWatcher)
        PersonBudgetid.editText?.addTextChangedListener(boardingTextWatcher)
        PersonIncomeid.editText?.addTextChangedListener(boardingTextWatcher)

        continueButtonid.setOnClickListener {
            val name = PersonNameid.editText?.text.toString()
            val budget = PersonBudgetid.editText?.text.toString()
            val income = PersonIncomeid.editText?.text.toString()

            saveCredentials(name, budget, income)

            println("name = $name budget = $budget")
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToTransactionListFragment()
            )
        }

    }

    private val boardingTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            val personName = PersonNameid.editText?.text.toString()
            val personBudget = PersonBudgetid.editText?.text.toString()


            if (personName.isEmpty()) {
                continueButtonid.isEnabled = false
                PersonNameid.error = "This field cannot be empty"
            }

            if (personBudget.isEmpty()) {
                continueButtonid.isEnabled = false
                PersonBudgetid.error = "This field cannot be empty"
            } else {
                continueButtonid.isEnabled = true
                PersonBudgetid.error = null
                PersonNameid.error = null
            }
        }

    }

    private fun saveCredentials(name: String, budget: String, income: String) {
        sharedPreferences.edit().putBoolean("isLogin", true).apply()
        sharedPreferences.edit().putString("Name", name).apply()
        sharedPreferences.edit().putString("Budget", budget).apply()
        sharedPreferences.edit().putString("Income", income).apply()

    }
}

package com.example.expansemanager.loginandsave

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expansemanager.R
import kotlinx.android.synthetic.main.fragment_saved_profile.*

class SavedProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saved_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sharedPreferences: SharedPreferences =
            this.requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)

        val tempName = sharedPreferences.getString("Name", "Rishav")
        val tempBudget = sharedPreferences.getString("Budget", "1000")
        val tempIncome = sharedPreferences.getString("Income", "1000")

        name_savedid.editText?.setText(tempName)
        budget_savedid.editText?.setText(tempBudget)
        income_savedid.editText?.setText(tempIncome)

        name_savedid.isEnabled = false
        budget_savedid.isEnabled = false
        income_savedid.isEnabled = false


        addAppBar2id.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {


                R.id.edit_pencilid -> {
                    name_savedid.isEnabled = true
                    budget_savedid.isEnabled = true
                    income_savedid.isEnabled = true

                    saveButtonid.setOnClickListener {

                        sharedPreferences.edit()
                            .putString("Name", name_savedid.editText?.text.toString()).apply()
                        sharedPreferences.edit()
                            .putString("Budget", budget_savedid.editText?.text.toString()).apply()
                        sharedPreferences.edit()
                            .putString("Income", income_savedid.editText?.text.toString()).apply()

                        findNavController().navigate(
                            SavedProfileFragmentDirections.actionSavedProfileFragmentToTransactionListFragment()
                        )
                    }
                    true
                }
                else -> false
            }
        }

    }
}
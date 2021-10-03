package com.example.expansemanager.MonthList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expansemanager.R
import kotlinx.android.synthetic.main.fragment_monthly_transactions.*


class MonthlyTransactionsFragment : Fragment() {

    private lateinit var viewModel: MonthlyTransactionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MonthlyTransactionViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_monthly_transactions, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(month_recycler_viewID) {
            layoutManager = LinearLayoutManager(activity)
            adapter = MonthlyCardAdapter({
                findNavController().navigate(
                    MonthlyTransactionsFragmentDirections.actionMonthlyTransactionsFragmentToMonthlyDetailFragment(
                        it
                    ),
                )
            }, requireContext())
        }


        viewModel.month.observe(viewLifecycleOwner, Observer {
            (month_recycler_viewID.adapter as MonthlyCardAdapter).submitList(it)
        })
    }
}
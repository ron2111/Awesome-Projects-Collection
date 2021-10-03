package com.example.expansemanager.UpcomingTransactions

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expansemanager.R
import com.example.expansemanager.R.id.*
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.fragment_monthly_detail.*
import kotlinx.android.synthetic.main.fragment_transaction_list.*


class TransactionListFragment : Fragment() {

    private lateinit var viewModel: TransactionListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setHasOptionsMenu(true)

        viewModel = ViewModelProviders.of(this).get(TransactionListViewModel::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction_list, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(recyclerViewDetailid) {
            layoutManager = LinearLayoutManager(activity)
            adapter = TransactionAdapter {
                findNavController().navigate(
                    TransactionListFragmentDirections.actionTransactionListFragmentToTransactionDetailFragment(
                        it
                    )
                )
            }
        }



        val sharedPreferences: SharedPreferences =
            this.requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        setNetBalance(sharedPreferences, editor)

        name_textid.text = sharedPreferences.getString("Name", "illuminati").toString()

        addAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {

                profileid -> {
                    findNavController().navigate(TransactionListFragmentDirections.actionTransactionListFragmentToSavedProfileFragment())
                    true
                }

                calender_view -> {
                    findNavController().navigate(TransactionListFragmentDirections.actionTransactionListFragmentToDayTransactionFragment())
                    true
                }

                news_click->{
                    findNavController().navigate(TransactionListFragmentDirections.actionTransactionListFragmentToNewsFragment())
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {

                daily -> {
                    true
                }

                add_expanse -> {
                    findNavController().navigate(
                        TransactionListFragmentDirections.actionTransactionListFragmentToTransactionDetailFragment(
                            0
                        )
                    )
                    true
                }

                monthly -> {
                    findNavController().navigate(TransactionListFragmentDirections.actionTransactionListFragmentToMonthlyTransactionsFragment())
                    true
                }
                else -> false
            }
        }

        viewModel.transactions.observe(viewLifecycleOwner, Observer {
            (recyclerViewDetailid.adapter as TransactionAdapter).submitList(it)
        })
    }

    private fun setupPieChart() {

        val pieEntries = arrayListOf<PieEntry>()
        var first: Float = amount_remaining2id.text.toString().toFloat()
        var second: Float = netCashid.text.toString().toFloat()
        var third: Float = netCreditid.text.toString().toFloat()
        var forth: Float = netDebitid.text.toString().toFloat()

        pieEntries.add(PieEntry(first))
        pieEntries.add(PieEntry(second))
        pieEntries.add(PieEntry(third))
        pieEntries.add(PieEntry(forth))

        pieChart.animateXY(1000, 1000)


        val pieDataSet = PieDataSet(pieEntries, "This is Pie Chart Label")
        pieDataSet.setColors(
            resources.getColor(R.color.R),
            resources.getColor(R.color.Java),
            resources.getColor(R.color.CPP),
            resources.getColor(R.color.Python)
        )


        val pieData = PieData(pieDataSet)


        pieChart.centerText = "Expanses"
        pieChart.setCenterTextColor(resources.getColor(android.R.color.black))
        pieChart.setCenterTextSize(15f)


        pieChart.legend.isEnabled = false


        pieChart.description.isEnabled = false
        pieChart.description.text = "Expanses"

        pieChart.holeRadius = 40f

        pieData.setDrawValues(true)

        pieChart.data = pieData
    }


    private fun setNetBalance(
        sharedPreferences: SharedPreferences,
        editor: SharedPreferences.Editor
    ) {


        var remainingAmount: Float = sharedPreferences.getString("Budget", "0")!!.toFloat()

        println("Net Amount $remainingAmount")
        amount_remaining2id.text = remainingAmount.toString()
        viewModel.netAmount.observe(viewLifecycleOwner, Observer {


            if (it != null) {
                remainingAmount = sharedPreferences.getString("Budget", "0")!!.toFloat()
                remainingAmount += it

                editor.putString("Budget", remainingAmount.toString())
                amount_remaining2id.text = remainingAmount.toString()
                setupPieChart()
                if (remainingAmount >= 0)
                    amount_remaining2id.setTextColor(Color.parseColor("#ADFF2F"))
                else if (remainingAmount < 0) {
                    amount_remaining2id.setTextColor(Color.parseColor("#ff726f"))
                }
            }
        })

        viewModel.netAmountCash.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                netCashid.text = it.toString()
                setupPieChart()
            }

        })

        viewModel.netAmountCredit.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                netCreditid.text = it.toString()
                setupPieChart()
            }
        })

        viewModel.netAmountDebit.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                netDebitid.text = it.toString()
                setupPieChart()
            }
        })

    }
}
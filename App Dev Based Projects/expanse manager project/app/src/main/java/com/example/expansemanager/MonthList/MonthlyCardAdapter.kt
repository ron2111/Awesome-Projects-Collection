package com.example.expansemanager.MonthList

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.expansemanager.R
import com.example.expansemanager.data.MonthlyTransactions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_monthly_list.*

class MonthlyCardAdapter(private val listener: (Long) -> Unit, val context: Context) :
    ListAdapter<MonthlyTransactions, MonthlyCardAdapter.ViewHolder>(
        DiffCallback2()
    ) {

    private var viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_monthly_list, parent, false)

        return ViewHolder(itemLayout, context)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(override val containerView: View, val context: Context) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        init {
            itemView.setOnClickListener {
                listener.invoke(getItem(adapterPosition).monthYear)
            }

        }


        @SuppressLint("WrongConstant")
        fun bind(monthlyTransactions: MonthlyTransactions) {
            with(monthlyTransactions) {
                month_nameid.text = selectMonth(monthlyTransactions.month)
                year_nameID.text = " " + monthlyTransactions.year.toString()
                val childLayoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
                childLayoutManager.initialPrefetchItemCount = 4
                recyclerView21.apply {
                    layoutManager = childLayoutManager
                    adapter = MonthAdapter(monthlyTransactions.children)
                    setRecycledViewPool(viewPool)
                }

            }


        }

        private fun selectMonth(month: Int): String {
            when (month) {
                1 -> return "January"
                2 -> return "February"
                3 -> return "March"
                4 -> return "April"
                5 -> return "May"
                6 -> return "June"
                7 -> return "July"
                8 -> return "August"
                9 -> return "September"
                10 -> return "October"
                11 -> return "November"
                12 -> return "December"
                else -> return "Invalid"
            }
        }
    }


}


class DiffCallback2 : DiffUtil.ItemCallback<MonthlyTransactions>() {
    override fun areItemsTheSame(
        oldItem: MonthlyTransactions,
        newItem: MonthlyTransactions
    ): Boolean {
        return oldItem.monthYear == newItem.monthYear
    }

    override fun areContentsTheSame(
        oldItem: MonthlyTransactions,
        newItem: MonthlyTransactions
    ): Boolean {
        return oldItem == newItem
    }
}

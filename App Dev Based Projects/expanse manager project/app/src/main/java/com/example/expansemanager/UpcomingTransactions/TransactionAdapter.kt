package com.example.expansemanager.UpcomingTransactions

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.expansemanager.R
import com.example.expansemanager.data.Transaction
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.*
import kotlinx.android.synthetic.main.list_item.view.*


class TransactionAdapter(private val listener: (Long) -> Unit) :
    ListAdapter<Transaction, TransactionAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        init {
            itemView.setOnClickListener {
                listener.invoke(getItem(adapterPosition).id)
            }
        }

        fun bind(transaction: Transaction) {
            with(transaction) {

                transaction_name.text = transaction.name

                if (transaction.type.equals(0)) {
                    itemView.transaction_mode.text = "Cash"
                } else if (transaction.type.equals(1)) {
                    itemView.transaction_mode.text = "Debit Card"
                } else {
                    itemView.transaction_mode.text = "Credit Card"
                }

                itemView.transaction_amount.text = transaction.amount.toString()

                itemView.transaction_date.text = transaction.date

                if (transaction.plusMinus == 1) {
                    itemView.plus_minus.text = "+"
                    itemView.plus_minus.setTextColor(Color.parseColor("#ADFF2F"))
                    itemView.transaction_amount.setTextColor(Color.parseColor("#ADFF2F"))
                    itemView.type_view.setBackgroundColor(Color.parseColor("#ADFF2F"))
                } else if (transaction.plusMinus == 0) {
                    itemView.plus_minus.text = "-"
                    itemView.plus_minus.setTextColor(Color.parseColor("#ff726f"))
                    itemView.transaction_amount.setTextColor(Color.parseColor("#ff726f"))
                    itemView.type_view.setBackgroundColor(Color.parseColor("#ff726f"))
                }
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Transaction>() {
    override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
        return oldItem == newItem
    }
}
package com.example.expansemanager.data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Expense(
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "amount")
    var amount: Float
)
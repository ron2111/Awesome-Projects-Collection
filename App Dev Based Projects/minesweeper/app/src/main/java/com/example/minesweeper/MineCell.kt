package com.example.minesweeper

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class MineCell: AppCompatButton {

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    )

    var value:Int = 0
    var isRevealed: Boolean = false
    var isMarked: Boolean = false
    var isMine : Boolean = false
}
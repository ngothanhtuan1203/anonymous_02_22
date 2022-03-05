package com.android.anonymous_02_22.ui.recycler

import android.content.Context
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.android.anonymous_02_22.R

class RecyclerDividerItemDecoration(context: Context): DividerItemDecoration(context, RecyclerView.VERTICAL) {

    private val mDivider = ContextCompat.getDrawable(context, R.drawable.divider)!!

    private var unDrawList: List<Int>? = null

    fun unDrawPositions(unDrawItems: List<Int>?) {
        this.unDrawList = unDrawItems
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        c.save()
        val list = unDrawList
        val dividerLeft = parent.paddingLeft
        val dividerRight = parent.width - parent.paddingRight
        val count = parent.childCount
        for (i in 0 until count) {
            val child = parent.getChildAt(i)
            val index = parent.getChildAdapterPosition(child)
            if (list == null || !list.contains(index)) {
                val params = child.layoutParams as RecyclerView.LayoutParams
                val dividerTop = child.bottom + params.bottomMargin
                val dividerBottom = dividerTop + mDivider.intrinsicHeight
                mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                mDivider.draw(c)
            }
        }
        c.restore()
    }
}

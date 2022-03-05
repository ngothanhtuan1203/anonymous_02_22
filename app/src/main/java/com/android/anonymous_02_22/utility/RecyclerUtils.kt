package com.android.anonymous_02_22.utility

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.anonymous_02_22.ui.recycler.OffsetItemDecoration
import com.android.anonymous_02_22.ui.recycler.RecyclerDividerItemDecoration

fun RecyclerView.setupLayout(orientation: Int, divider: Boolean = true) {
    val layoutManager = LinearLayoutManager(context)
    layoutManager.orientation = orientation
    this.layoutManager = layoutManager
    if (divider) {
        addItemDecoration(
            RecyclerDividerItemDecoration(
                context
            )
        )
    }
}

fun RecyclerView.setupGridLayout(spanCount: Int, spacing: Int = 0) {
    val layoutManager = GridLayoutManager(context, spanCount)
    layoutManager.orientation = RecyclerView.VERTICAL
    this.layoutManager = layoutManager
    addItemDecoration(
        OffsetItemDecoration(
            spanCount,
            spacing,
            true
        )
    )
}

fun RecyclerView.setupStaggeredLayout(spanCount: Int, spacing: Int = 0, orientation: Int = StaggeredGridLayoutManager.HORIZONTAL) {
    val layoutManager = StaggeredGridLayoutManager(spanCount, orientation).apply {
        gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
    }
    this.layoutManager = layoutManager
    addItemDecoration(
            OffsetItemDecoration(
                    spanCount,
                    spacing,
                    true
            )
    )
}

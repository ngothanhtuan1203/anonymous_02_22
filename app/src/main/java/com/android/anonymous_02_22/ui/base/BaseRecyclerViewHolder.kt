package com.android.anonymous_02_22.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseRecyclerViewHolder<ViewBinding: ViewDataBinding>(open val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)
package com.android.anonymous_02_22.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import java.util.concurrent.Executors

abstract class BaseRecyclerAdapter<Item, ViewBinding: ViewDataBinding>(callback: DiffUtil.ItemCallback<Item>)
    : ListAdapter<Item, BaseRecyclerViewHolder<ViewBinding>>(AsyncDifferConfig.Builder<Item>(callback).setBackgroundThreadExecutor(Executors.newSingleThreadExecutor()).build()) {

    @get:LayoutRes
    abstract val layoutId: Int
    abstract val itemBindingVariable: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<ViewBinding> {
        return BaseRecyclerViewHolder(DataBindingUtil.inflate<ViewBinding>(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
        ).apply { bindFirstTime(this)})
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<ViewBinding>, position: Int) {
        try {
            val item: Item = getItem(position)
            holder.binding.setVariable(itemBindingVariable, item)
            setExtraBindingVariable(holder.binding)
            bindView(holder.binding, item, position)
        } catch (e: IndexOutOfBoundsException) {
            bind(holder.binding, position)
        }
        holder.binding.executePendingBindings()
    }

    protected open fun setExtraBindingVariable(viewBinding: ViewBinding) {}

    protected open fun bindFirstTime(binding: ViewBinding) {}

    /**
     * override if need
     * bind view
     */
    protected open fun bindView(binding: ViewBinding, item: Item, position: Int) {}

    protected open fun bind(binding: ViewBinding, position: Int) {}

}
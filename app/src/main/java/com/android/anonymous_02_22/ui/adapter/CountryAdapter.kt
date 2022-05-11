package com.android.anonymous_02_22.ui.adapter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.android.anonymous_02_22.BR
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.RowItemContryBinding
import com.android.anonymous_02_22.domain.entities.CountryInfo
import com.android.anonymous_02_22.ui.base.BaseRecyclerAdapter
import com.android.anonymous_02_22.ui.fragment.CountryListViewModel
import com.android.anonymous_02_22.utility.JsonUtil

class CountryAdapter(private val mainViewModel: CountryListViewModel) :
    BaseRecyclerAdapter<CountryInfo, RowItemContryBinding>(object :
        DiffUtil.ItemCallback<CountryInfo>() {
        override fun areItemsTheSame(oldItem: CountryInfo, newItem: CountryInfo): Boolean {
            return (oldItem.id == newItem.id)
        }

        override fun areContentsTheSame(oldItem: CountryInfo, newItem: CountryInfo): Boolean {
            return oldItem == newItem
        }
    }) {
    override val layoutId: Int = R.layout.row_item_contry
    override val itemBindingVariable: Int = BR._all

    lateinit var viewBinding: RowItemContryBinding

    private fun setItemSelected(position: Int, data: String) {
        mainViewModel.setItemSelect(position, data)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun bindView(binding: RowItemContryBinding, item: CountryInfo, position: Int) {
        super.bindView(binding, item, position)
        viewBinding = binding
        viewBinding.apply {

            root.setOnClickListener {

                val itemData = JsonUtil.toJsonString(item)
                setItemSelected(position, itemData)
            }

            imageFlag.load("file:///android_asset/${item.symbol}") {
                crossfade(true)
                crossfade(1000)
                scale(Scale.FILL)

            }
            tvCountryName.text = item.name

        }
    }
}
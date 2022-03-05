package com.android.anonymous_02_22.ui.adapter

import android.app.TimePickerDialog
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Base64
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.BR
import com.android.anonymous_02_22.databinding.RowCryptoNewsItemBinding
import com.android.anonymous_02_22.domain.entities.CryptoInfo
import com.android.anonymous_02_22.ui.DemoViewModel
import com.android.anonymous_02_22.ui.base.BaseRecyclerAdapter
import java.util.*

class CryptoCurrencyAdapter(private val demoViewModel: DemoViewModel) :
    BaseRecyclerAdapter<CryptoInfo, RowCryptoNewsItemBinding>(object :
        DiffUtil.ItemCallback<CryptoInfo>() {
        override fun areItemsTheSame(oldItem: CryptoInfo, newItem: CryptoInfo): Boolean {
            return (oldItem.id == newItem.id) && (oldItem.id == newItem.id)
        }

        override fun areContentsTheSame(oldItem: CryptoInfo, newItem: CryptoInfo): Boolean {
            return oldItem == newItem
        }
    }) {
    override val layoutId: Int = R.layout.row_crypto_news_item
    override val itemBindingVariable: Int = BR._all

    lateinit var viewBinding: RowCryptoNewsItemBinding

    private fun setItemSelected(position: Int, euid: String) {
        demoViewModel.setItemSelect(position, euid)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun bindView(binding: RowCryptoNewsItemBinding, item: CryptoInfo, position: Int) {
        super.bindView(binding, item, position)
        viewBinding = binding
        viewBinding.apply {

            root.setOnClickListener {
                setItemSelected(position, item.id)
            }

            viewBinding.currencyLabelTextview.text = item.id.substring(0,1)
            viewBinding.currencyInfoTextview.text = item.name
            viewBinding.currencySymbols.text = item.symbol

        }
    }
}
package com.android.anonymous_02_22.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.FragmentCurrencyListBinding
import com.android.anonymous_02_22.ui.adapter.CryptoCurrencyAdapter
import com.android.anonymous_02_22.ui.base.BaseFragment
import com.android.anonymous_02_22.utility.setupLayout

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CurrencyListFragment : BaseFragment<DemoViewModel, FragmentCurrencyListBinding>() {

    override val viewModel: DemoViewModel by activityViewModels()
    override val layoutId: Int = R.layout.fragment_currency_list
    private val crypticAdapter: CryptoCurrencyAdapter by lazy { CryptoCurrencyAdapter(viewModel) }

    override fun initObserver() {
        viewModel.apply {
            itemList.observe(viewLifecycleOwner
            ) { playlist ->
                if (playlist != null) {
                    crypticAdapter.submitList(playlist) {
                        crypticAdapter.notifyItemRangeChanged(0, playlist.count())
                    }

                }
            }
        }

        super.initObserver()
    }

    override fun setBindingVariable(viewBinding: FragmentCurrencyListBinding) {
        viewBinding.apply {
            rvCryptic.apply {
                setupLayout(RecyclerView.VERTICAL)
                adapter = crypticAdapter

            }
        }

    }

}
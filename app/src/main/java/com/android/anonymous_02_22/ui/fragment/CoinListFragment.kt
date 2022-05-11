package com.android.anonymous_02_22.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.FragmentCoinListBinding
import com.android.anonymous_02_22.ui.adapter.CoinAdapter
import com.android.anonymous_02_22.ui.base.BaseFragment
import com.android.anonymous_02_22.utility.Constant.COIN_DETAIL
import com.android.anonymous_02_22.utility.setupLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinListFragment : BaseFragment<CoinListViewModel, FragmentCoinListBinding>() {

    override val viewModel: CoinListViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_coin_list
    private val foundUserAdapter: CoinAdapter by lazy { CoinAdapter(viewModel) }
    override fun initObserver() {
        super.initObserver()
        viewModel.apply {
            itemList.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    foundUserAdapter.submitList(it)
                }
            }
            itemSelectedData.observe(viewLifecycleOwner) {
                if (it != null) {
                    val bundle = Bundle()
                    bundle.putString(COIN_DETAIL, it)
                    findNavController().navigate(R.id.action_to_detail, bundle)
                    viewModel.resetData()
                }
            }



        }

    }

    override fun setBindingVariable(viewBinding: FragmentCoinListBinding) {
        viewBinding.apply {

            imageClear.visibility = View.INVISIBLE

            rvListCoin.apply {
                setupLayout(RecyclerView.VERTICAL)
                adapter = foundUserAdapter
                //method action search

                imageClear.setOnClickListener {
                    searchUser.setText("")
                }

            }


            viewModel.getCoins()
        }
    }

}
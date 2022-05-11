package com.android.anonymous_02_22.ui.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.FragmentCountryListBinding
import com.android.anonymous_02_22.ui.adapter.CountryAdapter
import com.android.anonymous_02_22.ui.base.BaseFragment
import com.android.anonymous_02_22.utility.Constant.USER_DETAIL
import com.android.anonymous_02_22.utility.setupLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryListFragment : BaseFragment<CountryListViewModel, FragmentCountryListBinding>() {

    override val viewModel: CountryListViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_country_list
    private val countryAdapter: CountryAdapter by lazy { CountryAdapter(viewModel) }
    override fun initObserver() {
        super.initObserver()
        viewModel.apply {
            itemList.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    countryAdapter.submitList(it)
                }
            }
            itemSelectedData.observe(viewLifecycleOwner) {
                if (it != null) {
                    val bundle = Bundle()
                    bundle.putString(USER_DETAIL, it)
                    findNavController().navigate(R.id.action_to_detail, bundle)
                    viewModel.resetData()
                }
            }
        }

    }

    override fun setBindingVariable(viewBinding: FragmentCountryListBinding) {
        viewBinding.apply {

            rvListUser.apply {
                setupLayout(RecyclerView.VERTICAL)
                adapter = countryAdapter
                //method action search

                viewModel.fetchCountry()

            }
        }
    }

}
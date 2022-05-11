package com.android.anonymous_02_22.ui.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.data.remote.respond.ModelSearchData
import com.android.anonymous_02_22.databinding.FragmentCoinDetailBinding
import com.android.anonymous_02_22.domain.entities.CoinInfo
import com.android.anonymous_02_22.ui.base.BaseFragment
import com.android.anonymous_02_22.utility.Constant.COIN_DETAIL
import com.android.anonymous_02_22.utility.Constant.USER_DETAIL
import com.android.anonymous_02_22.utility.JsonUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailFragment : BaseFragment<CoinDetailViewModel, FragmentCoinDetailBinding>() {

    private val TAG = CoinDetailFragment::class.simpleName
    override val viewModel: CoinDetailViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_coin_detail
    override fun initObserver() {
        super.initObserver()
        viewModel.apply {

        }

    }



    override fun setBindingVariable(viewBinding: FragmentCoinDetailBinding) {
        viewBinding.apply {

            val coinDetail = requireArguments().getString(COIN_DETAIL)
            Log.d(TAG,"COIN_DETAIL:$coinDetail")
            val userDetailObj = JsonUtil.fromJsonStringToObj(coinDetail,CoinInfo::class.java)
            Log.d(TAG,"userDetail name:${userDetailObj.name}")
            val userName = userDetailObj.name
            tvUsername.text = userName
            imageUser.load(userDetailObj.icon) {
                crossfade(true)
                crossfade(1000)
                transformations(CircleCropTransformation())
                scale(Scale.FILL)
            }

            tvCode.text = userDetailObj.base
            tvCounter.text = userDetailObj.counter
            tvBuyPrice.text = userDetailObj.buyPrice
            tvSellPrice.text = userDetailObj.sellPrice

            tvJsonData.text = userDetailObj.toString()
        }
    }

}
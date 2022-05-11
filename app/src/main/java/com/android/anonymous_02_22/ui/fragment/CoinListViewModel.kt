package com.android.anonymous_02_22.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.anonymous_02_22.domain.entities.CoinInfo
import com.android.anonymous_02_22.domain.usercase.HakoCoinUseCase
import com.android.anonymous_02_22.ui.base.BaseRecyclerViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinUseCase: HakoCoinUseCase
) : BaseRecyclerViewModel<CoinInfo>(coinUseCase) {

    private var _itemSelectedData = MutableLiveData<String?>()
    val itemSelectedData: LiveData<String?> = _itemSelectedData

    fun setItemSelect(position: Int, data: String) {
        _itemSelectedData.postValue(data)
    }

    override fun load(page: Int) {
        //TODO("Not yet implemented")

    }
    fun resetData() {
        _itemSelectedData.value = null
    }

    fun getCoins() {
        execute(true) {
            val data= coinUseCase.fetchCoins()
            itemList.value = data
        }
    }


}

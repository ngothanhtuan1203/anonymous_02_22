package com.android.anonymous_02_22.ui.fragment

import android.util.Log
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

    var fullList: List<CoinInfo> = emptyList<CoinInfo>()

    fun setItemSelect(position: Int, data: String) {
        _itemSelectedData.postValue(data)
    }

    override fun load(page: Int) {

    }
    fun resetData() {
        _itemSelectedData.value = null
    }

    fun searchCoin(keyword: String) {
        Log.d("TAG","keyword:$keyword")
        execute(true) {
            if (keyword.isEmpty()) {
                if (fullList.isEmpty()) {
                    val data = coinUseCase.fetchCoins()
                    fullList = data
                }
                itemList.value = fullList
            } else {
                val data = fullList.filter {
                    it.name?.trim()?.lowercase()?.contains(keyword.trim().lowercase()) == true
                            || it.base?.trim()?.lowercase()
                        ?.contains(keyword.trim().lowercase()) == true
                }
                itemList.value = data
            }
        }
    }




}

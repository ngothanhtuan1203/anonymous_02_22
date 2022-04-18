package com.android.anonymous_02_22.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.anonymous_02_22.domain.entities.CryptoInfo
import com.android.anonymous_02_22.domain.usercase.CryptoInfoUseCase
import com.android.anonymous_02_22.ui.base.BaseRecyclerViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DemoViewModel @Inject constructor(
    private val cryptoInfoUseCase: CryptoInfoUseCase
) : BaseRecyclerViewModel<CryptoInfo>(cryptoInfoUseCase) {
    private val TAG = DemoViewModel::class.simpleName

    private var _hasDbData = MutableLiveData<Boolean>()

    private var _itemSelectedLable = MutableLiveData<String>()
    val itemSelectedLable: LiveData<String> = _itemSelectedLable

    val hasDbData: LiveData<Boolean> = _hasDbData

    fun setItemSelect(position: Int, id: String) {
        _itemSelectedLable.postValue(id)
    }

    fun innitMockData() {
        execute(false) {
            cryptoInfoUseCase.initMockData()
            _hasDbData.value = true
        }
    }

    override fun load(page: Int) {
        execute(true) {
            val data = cryptoInfoUseCase.fetchAll()
            onApiSuccess(
                1,
                data, data.count(), false
            )
        }

    }

    fun sort() {
        execute(true) {
            var currentData = itemList.value ?: emptyList()
            currentData = currentData.sortedBy { it.id }

            onApiSuccess(
                1,
                currentData, currentData.count(), false
            )
        }
    }

}

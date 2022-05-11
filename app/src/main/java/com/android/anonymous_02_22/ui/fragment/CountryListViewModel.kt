package com.android.anonymous_02_22.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.anonymous_02_22.domain.entities.CountryInfo
import com.android.anonymous_02_22.domain.entities.FoundUser
import com.android.anonymous_02_22.domain.usercase.CountryUseCase
import com.android.anonymous_02_22.domain.usercase.SearchUserUseCase
import com.android.anonymous_02_22.ui.base.BaseRecyclerViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val countryUseCase: CountryUseCase
) : BaseRecyclerViewModel<CountryInfo>(countryUseCase) {

    private var _itemSelectedData = MutableLiveData<String>()
    val itemSelectedData: LiveData<String> = _itemSelectedData

    fun setItemSelect(position: Int, data: String) {
        _itemSelectedData.postValue(data)
    }

    override fun load(page: Int) {
        //TODO("Not yet implemented")

    }
    fun resetData() {
        _itemSelectedData.value = null
    }

    fun fetchCountry() {
        execute(true) {
            val data= countryUseCase.fetchCountries()
            itemList.value = data
        }
    }


}

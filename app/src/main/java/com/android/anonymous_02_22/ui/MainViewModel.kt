package com.android.anonymous_02_22.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.anonymous_02_22.domain.entities.FoundUser
import com.android.anonymous_02_22.domain.usercase.GitAppUseCase
import com.android.anonymous_02_22.ui.base.BaseRecyclerViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gitAppUseCase: GitAppUseCase
) : BaseRecyclerViewModel<FoundUser>(gitAppUseCase) {

    private var _itemSelectedLable = MutableLiveData<String>()
    val itemSelectedLable: LiveData<String> = _itemSelectedLable

    fun setItemSelect(position: Int, id: String) {
        _itemSelectedLable.postValue(id)
    }

    override fun load(page: Int) {
        //TODO("Not yet implemented")

    }

    fun searchUsers(keyword:String) {
        execute(true) {
            val data= gitAppUseCase.searchUsers(keyword)
            itemList.value = data
        }
    }


}

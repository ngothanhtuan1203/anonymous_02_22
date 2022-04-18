package com.android.anonymous_02_22.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.anonymous_02_22.domain.entities.FoundUser
import com.android.anonymous_02_22.domain.usercase.SearchUserUseCase
import com.android.anonymous_02_22.ui.base.BaseRecyclerViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val searchUserUseCase: SearchUserUseCase
) : BaseRecyclerViewModel<FoundUser>(searchUserUseCase) {

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

    fun searchUsers(keyword:String) {
        execute(true) {
            val data= searchUserUseCase.searchUsers(keyword)
            itemList.value = data
        }
    }


}

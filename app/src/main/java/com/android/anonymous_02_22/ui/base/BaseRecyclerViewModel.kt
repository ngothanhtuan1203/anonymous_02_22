package com.android.anonymous_02_22.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.anonymous_02_22.domain.usercase.BaseUseCase
import com.android.anonymous_02_22.domain.usercase.CryptoInfoUseCase

abstract class BaseRecyclerViewModel<Item> constructor(baseUseCase: BaseUseCase) : BaseViewModel(baseUseCase) {
    protected open val initialPage = 1
    abstract fun load(page: Int = initialPage)
    val isEndReached = MutableLiveData(false)
    val itemList = MutableLiveData<List<Item>>()
    var onSearch:Boolean = false

    val totalItemFound = MutableLiveData<Int>(-1)

    private var _currentPage = 0

    val isLoadingMore = MutableLiveData(false)
    val isRefreshing = MutableLiveData(false)



    private fun resetLoadMore() {
        isEndReached.postValue(false)
    }

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        _isLoading = true
        isRefreshing.postValue(true)
        load(initialPage)
    }

    protected fun onApiSuccess(page: Int, list: List<Item>,totalItems: Int,search:Boolean) {
        onSearch = search

        val newList = itemList.value?.toMutableList() ?: mutableListOf()
        _currentPage = page
        if (_currentPage == initialPage) {
            newList.clear()
            resetLoadMore()
        }

        newList.addAll(list)
        itemList.postValue(newList)

        if (totalItems == 0) {
            if (totalItemFound.value == -1) {
                totalItemFound.postValue(0)
            } else if (page == 1) {
                totalItemFound.postValue(0)
            }
        } else {
            totalItemFound.postValue(totalItems)
        }


        isEndReached.postValue(list.isEmpty())
        hideLoading()
        isLoadingMore.postValue(false)
        isRefreshing.postValue(false)

    }

    override fun handleError(throwable: Throwable) {
        super.handleError(throwable)
        isLoadingMore.postValue(false)
        isRefreshing.postValue(false)
    }




}
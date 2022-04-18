package com.android.anonymous_02_22.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.anonymous_02_22.domain.usercase.BaseUseCase
import com.android.anonymous_02_22.domain.usercase.CryptoInfoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

open class BaseViewModel @Inject constructor(
   private val baseUseCase: BaseUseCase
) : ViewModel() {
    protected var _isLoading = false
    val isLoading = MutableLiveData<Boolean>(_isLoading)
    private val TAG = BaseViewModel::class.simpleName


    protected fun <T> execute(showLoading: Boolean = true, fn: suspend () -> T) {
        viewModelScope.launch {
            try {
                if (showLoading) showLoading()
                fn()
                if (showLoading) hideLoading()
            } catch (throwable: Throwable) {
                handleError(throwable)
            }
        }
    }

    protected open fun hideLoading() {
        if (_isLoading) {
            _isLoading = false
            isLoading.value = false
        }
    }

    protected open fun showLoading() {
        if (!_isLoading) {
            _isLoading = true
            isLoading.value = true
        }
    }

    protected open fun handleError(throwable: Throwable) {
        hideLoading()

        handleAppError(throwable)
    }

    protected open fun handleAppError(throwable: Throwable) {
    }
}
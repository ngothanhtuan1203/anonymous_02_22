package com.android.anonymous_02_22.ui


import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import com.android.anonymous_02_22.domain.usercase.CryptoInfoUseCase
import com.android.anonymous_02_22.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val cryptoInfoUseCase: CryptoInfoUseCase
) : BaseViewModel(cryptoInfoUseCase) {
    private val TAG = CurrencyListViewModel::class.simpleName
}

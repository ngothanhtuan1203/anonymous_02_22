package com.android.anonymous_02_22.ui.fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.anonymous_02_22.domain.entities.GitProfile
import com.android.anonymous_02_22.domain.usercase.DetailUserUseCase
import com.android.anonymous_02_22.domain.usercase.SearchUserUseCase
import com.android.anonymous_02_22.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val detailUserUseCase: DetailUserUseCase
) : BaseViewModel(detailUserUseCase) {
    private val TAG = CoinDetailViewModel::class.simpleName

}

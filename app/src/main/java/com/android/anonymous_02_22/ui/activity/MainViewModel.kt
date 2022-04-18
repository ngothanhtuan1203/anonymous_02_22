package com.android.anonymous_02_22.ui.activity

import com.android.anonymous_02_22.domain.usercase.SearchUserUseCase
import com.android.anonymous_02_22.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchUserUseCase: SearchUserUseCase
) : BaseViewModel(searchUserUseCase)
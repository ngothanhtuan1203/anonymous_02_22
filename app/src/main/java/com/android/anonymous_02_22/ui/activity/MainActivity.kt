package com.android.anonymous_02_22.ui.activity

import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.ActivityMainBinding
import com.android.anonymous_02_22.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()
    override fun initObserver() {
        super.initObserver()


    }

    override fun onBackPressed() {
//        findNavController(R.id.nav_host_git_flow_fragments).popBackStack()
        super.onBackPressed()
    }

    override fun setBindingVariable(viewBinding: ActivityMainBinding) {

    }
}
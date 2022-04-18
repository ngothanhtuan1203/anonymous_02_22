package com.android.anonymous_02_22.ui

import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.ActivityDemoBinding
import com.android.anonymous_02_22.ui.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoActivity : BaseActivity<DemoViewModel, ActivityDemoBinding>() {

    override val viewModel: DemoViewModel by viewModels()
    override val layoutId: Int = R.layout.activity_demo

    override fun initObserver() {
        super.initObserver()
        viewModel.apply {
            hasDbData.observe(this@DemoActivity) {
                if (it) {
                    viewBinding.loadButton.isEnabled = true
                }
            }

            itemSelectedLable.observe(this@DemoActivity) {
                if (it != null) {
                    runOnUiThread {
                        Toast.makeText(this@DemoActivity, "Item selected:$it", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    override fun setBindingVariable(viewBinding: ActivityDemoBinding) {
        viewBinding.apply {
            viewBinding.loadButton.isEnabled = false
            loadButton.setOnClickListener {
                viewModel.load(1)
            }
            sortButton.setOnClickListener {
                viewModel.sort()
            }
            viewModel.innitMockData()
        }
    }
}
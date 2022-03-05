package com.android.anonymous_02_22.ui.base

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.WindowCompat.*
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.android.anonymous_02_22.ui.TNProgressDialog


abstract class BaseActivity<ViewModel : BaseViewModel, ViewBinding : ViewDataBinding> :
    AppCompatActivity() {
    protected abstract val viewModel: ViewModel

    var progressDialog : Dialog? = null
    @get:LayoutRes
    protected abstract val layoutId: Int

    open fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
        val win = activity.window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    protected lateinit var viewBinding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, layoutId) as ViewBinding
        viewBinding.apply {

            progressDialog = TNProgressDialog.progressDialog(this@BaseActivity)
            setBindingVariable(this)
            root.isClickable = true

            lifecycleOwner = this@BaseActivity
            executePendingBindings()

        }
        supportActionBar?.elevation = 0F
        try {
            actionBar!!.hide();
        } catch (e: Exception) {

        }


        initView()
        initObserver()
    }

    open fun initView() {}
    open fun initObserver() {
        viewModel.apply {

            isLoading.observe(this@BaseActivity, Observer {
                showLoading(it)
            })


        }
    }

    abstract fun setBindingVariable(viewBinding: ViewBinding)



    protected open fun showLoading(show: Boolean) {
        try {
           runOnUiThread {
                if (show) {
                    progressDialog!!.show()
                } else {
                    if (progressDialog != null && progressDialog!!.isShowing) {
                        progressDialog!!.dismiss()
                    }

                }

            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }


}
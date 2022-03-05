package com.android.anonymous_02_22.ui.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.ui.TNProgressDialog


abstract class BaseFragment<ViewModel : BaseViewModel, ViewBinding : ViewDataBinding> : Fragment() {
    @get:LayoutRes
    protected abstract val layoutId: Int
    abstract val viewModel: ViewModel

    protected lateinit var viewBinding: ViewBinding
//    var progressDialog : Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            setBindingVariable(this)
            root.isClickable = true
            lifecycleOwner = this@BaseFragment
            executePendingBindings()
//            progressDialog = TNProgressDialog.progressDialog(requireContext())

        }

        initView()
        initObserver()
    }

    open fun initView() {}
    open fun initObserver() {
        viewModel.apply {

            isLoading.observe(viewLifecycleOwner, Observer {
                showLoading(it)
            })
        }
    }

    abstract fun setBindingVariable(viewBinding: ViewBinding)

    protected fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


    protected open fun showLoading(show: Boolean) {
        try {
            requireActivity().runOnUiThread {
                if (show) {
//                    progressDialog!!.show()
                } else {
//                    if (progressDialog != null && progressDialog!!.isShowing) {
//                        progressDialog!!.dismiss()
//                    }

                }

            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }



    protected fun navigateTo(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    private val _slideFromRightOption = navOptions {
        anim {
            enter = R.anim.enter_from_right
            exit = R.anim.exit_to_left
            popEnter = R.anim.enter_from_left
            popExit = R.anim.exit_to_right
        }
    }

    protected fun slideTo(direction: NavDirections) {
        findNavController().navigate(direction, _slideFromRightOption)
    }
}
package com.android.anonymous_02_22.ui

import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.ActivityMainBinding
import com.android.anonymous_02_22.ui.adapter.FoundUserAdapter
import com.android.anonymous_02_22.ui.base.BaseActivity
import com.android.anonymous_02_22.utility.setupLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModels()
    override val layoutId: Int = R.layout.activity_main
    private val foundUserAdapter: FoundUserAdapter by lazy { FoundUserAdapter(viewModel) }
    override fun initObserver() {
        super.initObserver()
        viewModel.apply {
            itemList.observe(this@MainActivity) {
                if (it.isNotEmpty()) {
                    foundUserAdapter.submitList(it)
                }
            }
        }

    }

    override fun setBindingVariable(viewBinding: ActivityMainBinding) {
        viewBinding.apply {
            rvListUser.apply {
                setupLayout(RecyclerView.VERTICAL)
                adapter = foundUserAdapter
                //method action search
                searchUser.setOnEditorActionListener { v: TextView, actionId: Int, event: KeyEvent? ->
                    val strUsername = searchUser.text.toString()
                    if (strUsername.isEmpty()) {
                        imageClear.visibility = View.INVISIBLE
                    } else {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                            imageClear.visibility = View.VISIBLE
                            viewModel.searchUsers(strUsername)
                            val inputMethodManager = v.context
                                .getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                            inputMethodManager.hideSoftInputFromWindow(v.windowToken, 0)
                            return@setOnEditorActionListener true
                        }
                    }
                    false
                }

                imageClear.setOnClickListener {
                    searchUser.setText("")
                }

            }
        }
    }
}
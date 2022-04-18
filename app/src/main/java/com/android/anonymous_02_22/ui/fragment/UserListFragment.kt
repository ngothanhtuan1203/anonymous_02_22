package com.android.anonymous_02_22.ui.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.FragmentUserListBinding
import com.android.anonymous_02_22.ui.adapter.FoundUserAdapter
import com.android.anonymous_02_22.ui.base.BaseFragment
import com.android.anonymous_02_22.utility.Constant.USER_DETAIL
import com.android.anonymous_02_22.utility.setupLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : BaseFragment<UserListViewModel, FragmentUserListBinding>() {

    override val viewModel: UserListViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_user_list
    private val foundUserAdapter: FoundUserAdapter by lazy { FoundUserAdapter(viewModel) }
    override fun initObserver() {
        super.initObserver()
        viewModel.apply {
            itemList.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    foundUserAdapter.submitList(it)
                }
            }
            itemSelectedData.observe(viewLifecycleOwner) {
                if (it != null) {
                    val bundle = Bundle()
                    bundle.putString(USER_DETAIL, it)
                    findNavController().navigate(R.id.action_to_detail, bundle)
                    viewModel.resetData()
                }
            }
        }

    }

    override fun setBindingVariable(viewBinding: FragmentUserListBinding) {
        viewBinding.apply {

            imageClear.visibility = View.INVISIBLE

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
                                .getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
                            inputMethodManager.hideSoftInputFromWindow(v.windowToken, 0)
                            return@setOnEditorActionListener true
                        }
                    }
                    false
                }

                searchUser.doAfterTextChanged {
                    if (it?.isEmpty() == true) {
                        imageClear.visibility = View.INVISIBLE
                    } else {
                        imageClear.visibility = View.VISIBLE
                    }
                }

                imageClear.setOnClickListener {
                    searchUser.setText("")
                }

            }
        }
    }

}
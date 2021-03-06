package com.android.anonymous_02_22.ui.adapter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.android.anonymous_02_22.BR
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.databinding.RowItemUsersBinding
import com.android.anonymous_02_22.domain.entities.FoundUser
import com.android.anonymous_02_22.ui.base.BaseRecyclerAdapter
import com.android.anonymous_02_22.ui.fragment.UserListViewModel
import com.android.anonymous_02_22.utility.JsonUtil

class FoundUserAdapter(private val mainViewModel: UserListViewModel) :
    BaseRecyclerAdapter<FoundUser, RowItemUsersBinding>(object :
        DiffUtil.ItemCallback<FoundUser>() {
        override fun areItemsTheSame(oldItem: FoundUser, newItem: FoundUser): Boolean {
            return (oldItem.login == newItem.login)
        }

        override fun areContentsTheSame(oldItem: FoundUser, newItem: FoundUser): Boolean {
            return oldItem == newItem
        }
    }) {
    override val layoutId: Int = R.layout.row_item_users
    override val itemBindingVariable: Int = BR._all

    lateinit var viewBinding: RowItemUsersBinding

    private fun setItemSelected(position: Int, data: String) {
        mainViewModel.setItemSelect(position, data)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun bindView(binding: RowItemUsersBinding, item: FoundUser, position: Int) {
        super.bindView(binding, item, position)
        viewBinding = binding
        viewBinding.apply {

            root.setOnClickListener {

                val itemData = JsonUtil.toJsonString(item)
                setItemSelected(position, itemData)
            }

            imageUser.load(item.avatarUrl) {
                crossfade(true)
                crossfade(1000)
                transformations(CircleCropTransformation())
                scale(Scale.FILL)

            }
            tvUsername.text = item.login
            tvUrl.text = item.htmlUrl

        }
    }
}
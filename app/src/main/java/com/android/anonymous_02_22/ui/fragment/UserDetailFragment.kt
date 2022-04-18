package com.android.anonymous_02_22.ui.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.android.anonymous_02_22.R
import com.android.anonymous_02_22.data.remote.respond.ModelSearchData
import com.android.anonymous_02_22.databinding.FragmentUserDetailBinding
import com.android.anonymous_02_22.ui.base.BaseFragment
import com.android.anonymous_02_22.utility.Constant.USER_DETAIL
import com.android.anonymous_02_22.utility.JsonUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user_detail.*

@AndroidEntryPoint
class UserDetailFragment : BaseFragment<UserDetailViewModel, FragmentUserDetailBinding>() {

    private val TAG = UserDetailFragment::class.simpleName
    override val viewModel: UserDetailViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_user_detail
    override fun initObserver() {
        super.initObserver()
        viewModel.apply {
            userDetail.observe(viewLifecycleOwner) {
                if (it != null) {
                    viewBinding.apply {
                        tvBio.text = it.bio.toString()
                        tvFollowers.text = it.followers.toString()
                        tvFollowing.text = it.following
                        tvRepository.text = it.publicRepos

                        tvJsonData.text = it.toString()
                    }
                }
            }
        }

    }



    override fun setBindingVariable(viewBinding: FragmentUserDetailBinding) {
        viewBinding.apply {

            val userDetail = requireArguments().getString(USER_DETAIL)
            Log.d(TAG,"userDetail:$userDetail")
            val userDetailObj = JsonUtil.fromJsonStringToObj(userDetail,ModelSearchData::class.java)
            Log.d(TAG,"userDetail name:${userDetailObj.login}")
            val userName = userDetailObj.login
            tvUsername.text = userName
            viewModel.fetchUserDetail(userName?:"")
            imageUser.load(userDetailObj.avatarUrl) {
                crossfade(true)
                crossfade(1000)
                transformations(CircleCropTransformation())
                scale(Scale.FILL)
            }
        }
    }

}
package com.asthiseta.bismillahtest.follow

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.asthiseta.bismillahtest.databinding.FollowFragmentBinding
import com.asthiseta.bismillahtest.databinding.HomeFragmentBinding
import com.asthiseta.bismillahtest.util.ShowState
import com.asthiseta.core.ui.UserAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class FollowFragment : Fragment() , ShowState{

    private var _followBinding : FollowFragmentBinding? = null
    private  val followBinding get() = _followBinding!!

    private lateinit var followAdapter: UserAdapter
    private lateinit var username: String

    private var type: String? = null
    private val followViewModel: FollowViewModel by viewModel()

    override fun onSuccessState(
        homeFragmentBinding: HomeFragmentBinding?,
        followFragmentBinding: FollowFragmentBinding?
    ) {
        TODO("Not yet implemented")
    }

    override fun onLoadingState(
        homeFragmentBinding: HomeFragmentBinding?,
        followFragmentBinding: FollowFragmentBinding?
    ) {
        TODO("Not yet implemented")
    }

    override fun onErrorState(
        homeFragmentBinding: HomeFragmentBinding?,
        followFragmentBinding: FollowFragmentBinding?,
        message: String?
    ) {
        TODO("Not yet implemented")
    }

    companion object{
        fun newInstance(username: String, type: String) =
            FollowFragment().apply {
                arguments = Bundle().apply {
                    putString(USERNAME, username)
                    putString(TYPE, type)
                }
            }

        private const val USERNAME ="username"
        private const val TYPE = "type"
    }
}
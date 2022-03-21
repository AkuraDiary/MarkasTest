package com.asthiseta.bismillahtest.follow

import androidx.fragment.app.Fragment
import com.asthiseta.bismillahtest.databinding.FollowFragmentBinding
import com.asthiseta.bismillahtest.databinding.HomeFragmentBinding
import com.asthiseta.bismillahtest.util.ShowState

class FollowFragment : Fragment() , ShowState{
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
}
package com.asthiseta.bismillahtest.util

import com.asthiseta.bismillahtest.databinding.FollowFragmentBinding
import com.asthiseta.bismillahtest.databinding.HomeFragmentBinding

interface ShowState {

    fun onSuccessState(homeFragmentBinding : HomeFragmentBinding? = null, followFragmentBinding: FollowFragmentBinding? = null)
    fun onLoadingState(homeFragmentBinding : HomeFragmentBinding? = null, followFragmentBinding: FollowFragmentBinding? = null)
    fun onErrorState(homeFragmentBinding : HomeFragmentBinding? = null, followFragmentBinding: FollowFragmentBinding? = null)
}
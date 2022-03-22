package com.asthiseta.bismillahtest.follow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.asthiseta.bismillahtest.R
import com.asthiseta.bismillahtest.databinding.FollowFragmentBinding
import com.asthiseta.bismillahtest.databinding.HomeFragmentBinding
import com.asthiseta.bismillahtest.util.ShowState
import com.asthiseta.bismillahtest.util.TypeView
import com.asthiseta.core.ui.UserAdapter
import com.shashank.sony.fancytoastlib.FancyToast
import org.koin.android.viewmodel.ext.android.viewModel

class FollowFragment : Fragment() , ShowState{

    private var _followBinding : FollowFragmentBinding? = null
    private  val followBinding get() = _followBinding!!

    private lateinit var followAdapter: UserAdapter
    private lateinit var username: String

    private var type: String? = null
    private val followViewModel: FollowViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(USERNAME).toString()
            type = it.getString(TYPE)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followAdapter = UserAdapter(arrayListOf()) { user, _ ->
            FancyToast.makeText(context, user, FancyToast.LENGTH_SHORT, FancyToast.INFO, false).show()
        }

        followBinding.recylerFollow.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = followAdapter
        }

        when(type) {
            resources.getString(R.string.following) -> followViewModel.setFollow(username, TypeView.FOLLOWING)
            resources.getString(R.string.followers) -> followViewModel.setFollow(username, TypeView.FOLLOWER)
            else -> onErrorState(followFragmentBinding = followBinding, message = null)
        }

        observeFollow()
    }

    private fun observeFollow() {
        TODO("Not yet implemented")
    }

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
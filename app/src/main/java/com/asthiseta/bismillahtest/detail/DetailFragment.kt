package com.asthiseta.bismillahtest.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.PagerAdapter
import com.asthiseta.bismillahtest.databinding.DetailFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {
    private var _detailBinding : DetailFragmentBinding? = null
    private val detailBinding get() =_detailBinding!!
    private lateinit var pagerAdapter: PagerAdapter
    private val args: DetailFragmentArgs by navArgs()
    private val detailVM : DetailViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = args.username

        _detailBinding = DetailFragmentBinding.inflate(layoutInflater, container, false)
        detailBinding.lifecycleOwner = viewLifecycleOwner
        val view = detailBinding.root
        observeDetail()
        return view
    }

    private fun observeDetail() {
        TODO("Not yet implemented")
    }
}
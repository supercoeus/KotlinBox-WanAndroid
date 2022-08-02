package com.stew.kb_home.ui

import android.util.Log
import com.stew.kb_common.base.BaseVMFragment
import com.stew.kb_home.R
import com.stew.kb_home.databinding.FragmentHomeBinding
import com.stew.kb_home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by stew on 7/27/22.
 * mail: stewforani@gmail.com
 */
class HomeFragment : BaseVMFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun init() {
        homeViewModel.getBanner()
        homeViewModel.getArticle(currentPage)
    }

    override fun observe() {
        homeViewModel.bannerList.observe(this, {
            Log.d(TAG, "bannerList: " + it.size)
        })

        homeViewModel.articleList.observe(this, {
            Log.d(TAG, "articleList: " + it.size)
        })
    }

}
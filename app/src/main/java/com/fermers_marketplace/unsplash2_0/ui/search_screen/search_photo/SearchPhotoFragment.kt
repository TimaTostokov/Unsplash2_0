package com.fermers_marketplace.unsplash2_0.ui.search_screen.search_photo

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.fermers_marketplace.unsplash2_0.R
import com.fermers_marketplace.unsplash2_0.appComponent
import com.fermers_marketplace.unsplash2_0.common.fragmentAnim
import com.fermers_marketplace.unsplash2_0.constants.Const
import com.fermers_marketplace.unsplash2_0.databinding.FragmentSearchPhotoBinding
import com.fermers_marketplace.unsplash2_0.ui.base.BaseFragment
import com.fermers_marketplace.unsplash2_0.ui.photo_screen.PhotoClickListener
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SearchPhotoFragment : BaseFragment<SearchPhotoViewModel, FragmentSearchPhotoBinding>(),
    PhotoClickListener {

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        PagingSearchPhotoAdapter(this)
    }
    override val viewModelClass: Class<SearchPhotoViewModel>
        get() = SearchPhotoViewModel::class.java

    override fun createViewBinding(): FragmentSearchPhotoBinding =
        FragmentSearchPhotoBinding.inflate(layoutInflater)

    override fun inject() = appComponent.inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fspRvListPhoto.adapter = adapter.withLoadStateHeaderAndFooter(
            header = SearchPhotoLoadingStateAdapter(adapter = adapter),
            footer = SearchPhotoLoadingStateAdapter(adapter)
        )

        lifecycleScope.launch {
            viewModel.searchPhotosList.collectLatest { pagingData ->
                adapter.submitData(pagingData)

            }
        }

        val layoutManager = LinearLayoutManager(requireContext())
        binding.fspRvListPhoto.layoutManager = layoutManager

        adapter.addLoadStateListener { state: CombinedLoadStates ->
            if (adapter == null) binding.fspNotFound.visibility = View.VISIBLE
            binding.fspRvListPhoto.isVisible = state.refresh != LoadState.Loading
            binding.fspShimmerFrameLayout.isVisible = state.refresh == LoadState.Loading
        }
    }

    fun onQuery(query: String) {
        adapter.refresh()
        viewModel.setArgs(query)
    }

    override fun onPhotoClick(
        photoId: String,
        photoUrl: String,
        photoProfile: String,
        userName: String
    ) {
        val bundle = Bundle()
        bundle.putString(Const.PHOTO_ID_KEY, photoId)
        bundle.putString(Const.PHOTO_URL_KEY, photoUrl)
        bundle.putString(Const.PHOTO_PROFILE_KEY, photoProfile)
        bundle.putString(Const.USER_NAME_KEY, userName)
        findNavController().navigate(
            R.id.action_searchFragment_to_photoDetailsFragment,
            bundle,
            fragmentAnim()
        )
    }

    override fun onProfileImageClick(photoProfile: String, userName: String) {
        val bundle = Bundle()
        bundle.putString(Const.PHOTO_PROFILE_KEY, photoProfile)
        bundle.putString(Const.USER_NAME_KEY, userName)
        findNavController().navigate(
            R.id.action_searchFragment_to_userFragment, bundle,
            fragmentAnim()
        )
    }
}
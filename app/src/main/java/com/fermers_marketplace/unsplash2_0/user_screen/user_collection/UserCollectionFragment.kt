package com.fermers_marketplace.unsplash2_0.user_screen.user_collection

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.fermers_marketplace.unsplash2_0.Event
import com.fermers_marketplace.unsplash2_0.R
import com.fermers_marketplace.unsplash2_0.appComponent
import com.fermers_marketplace.unsplash2_0.common.Messages
import com.fermers_marketplace.unsplash2_0.common.fragmentAnim
import com.fermers_marketplace.unsplash2_0.common.observeData
import com.fermers_marketplace.unsplash2_0.common.snackbar
import com.fermers_marketplace.unsplash2_0.constants.Const
import com.fermers_marketplace.unsplash2_0.databinding.FragmentUserCollectionBinding
import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.ui.base.BaseFragment


class UserCollectionFragment :
    BaseFragment<UserCollectionViewModel, FragmentUserCollectionBinding>(),
    UserCollectionClickListener {

    /**
     * Подписка на получение и обновление данных из UserPhotoViewModel
     */
    override val viewModelClass: Class<UserCollectionViewModel>
        get() = UserCollectionViewModel::class.java

    private val adapter = UserCollectionAdapter(this)

    private val userName: String
        get() = arguments?.getString(Const.USER_NAME_KEY) ?: error("error")

    override fun createViewBinding(): FragmentUserCollectionBinding =
        FragmentUserCollectionBinding.inflate(layoutInflater)

    override fun inject() {
        appComponent.inject(this)
    }

    override fun observeViewModel() {

        /**
         * Получение и обновление данных о списке коллекций из UserPhotoViewModel
         */
        observeData(viewModel.userCollectionListDtoDto) { event ->
            when (event) {
                is Event.Loading -> onProgress()
                is Event.Success -> onSuccess(event.data)
                is Event.Error -> onError()
            }
        }

        /**
         * Получение и обновление данных о Messages из UserPhotoViewModel
         */
        observeData(viewModel.messageFlow) { messages ->
            when (messages) {
                is Messages.HideShimmer -> {
                    binding.fppShimmerFrameLayout.visibility = View.GONE
                    binding.fppShimmerFrameLayout.stopShimmer()
                }

                is Messages.ShowShimmer -> {
                    binding.fppShimmerFrameLayout.visibility = View.VISIBLE
                    binding.fppShimmerFrameLayout.startShimmer()
                }

                is Messages.NetworkIsDisconnected -> {
                    binding.fucDisconnected.visibility = View.VISIBLE
                }

                else -> {
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.setArgs(userName)
        super.onViewCreated(view, savedInstanceState)
        binding.fpcRvListCollection.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext())

        binding.fpcRvListCollection.layoutManager = layoutManager

        /**
         * Прогрузка следующей страницы в списке коллекций пользователя по достижении 5-го элемента страницы
         */
        binding.fpcRvListCollection.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val lastPosition = layoutManager.findLastVisibleItemPosition()
                if (lastPosition > (adapter.itemCount - 5)) {
                    viewModel.onLoadUserCollection()
                    (binding.fpcRvListCollection.itemAnimator as SimpleItemAnimator).supportsChangeAnimations =
                        false
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        binding.fpcSrlRefresh.setOnRefreshListener {
            adapter.clear()
            viewModel.onRefreshUserCollection()
            binding.fucDisconnected.visibility = View.GONE
        }
    }

    /**
     * Действия в момент загрузки данных
     */
    private fun onProgress() {
        binding.fpcSrlRefresh.isRefreshing = false
        binding.fucEmptyList.visibility = View.GONE
    }

    /**
     * Действия в момент успешной загрузки данных
     */
    private fun onSuccess(data: List<CollectionDto>) {
        try {
            binding.fpcRvListCollection.visibility = View.VISIBLE
            adapter.addUsersPhoto(data)

            if (adapter.itemCount == 0)
                binding.fucEmptyList.visibility = View.VISIBLE

        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    /**
     * Действия в момент ошибки загрузки данных
     */
    private fun onError() {
        snackbar(getString(R.string.network_is_disconnected_text))
    }

    /**
     * Переход на СollectionDetailsFragment с передачей аргументов
     *
     * @param collectionId
     * @param title
     */
    override fun onCollectionClick(collectionId: String, title: String) {
        val bundle = Bundle()
        bundle.putString(Const.COLLECTION_ID_KEY, collectionId)
        bundle.putString(Const.TITLE_KEY, title)
        findNavController().navigate(
            R.id.action_userFragment_to_collectionDetailsFragment,
            bundle,
            fragmentAnim()
        )
    }
}
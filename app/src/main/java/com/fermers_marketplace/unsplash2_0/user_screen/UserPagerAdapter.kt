package com.fermers_marketplace.unsplash2_0.user_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.fermers_marketplace.unsplash2_0.R
import com.fermers_marketplace.unsplash2_0.constants.Const
import com.fermers_marketplace.unsplash2_0.user_screen.user_collection.UserCollectionFragment
import com.fermers_marketplace.unsplash2_0.user_screen.users_photo.UserPhotoFragment

class UserPagerAdapter(
    fm: FragmentManager,
    private val userName: String, val context: Context
) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = NUM_ITEMS

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> UserPhotoFragment().apply {
                arguments = Bundle().apply {
                    putString(Const.USER_NAME_KEY, userName)
                }
            }

            else -> UserCollectionFragment().apply {
                arguments = Bundle().apply {
                    putString(Const.USER_NAME_KEY, userName)
                }
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        val title = if (position == 0) {
            context.getString(R.string.pf_text_photo)
        } else
            context.getString(R.string.pf_text_collection)
        return title
    }

    companion object {
        const val NUM_ITEMS = 2
    }
}
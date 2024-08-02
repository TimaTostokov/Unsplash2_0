package com.fermers_marketplace.unsplash2_0

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.aghajari.zoomhelper.ZoomHelper
import com.fermers_marketplace.unsplash2_0.databinding.ActivityMainBinding
import com.fermers_marketplace.unsplash2_0.ui.login_screen.LoginFragment
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        /**
         * Переключение между элементами BottomBar
         */
        binding?.maBottomBar?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bnbItemPhoto -> replaceFragment(R.id.go_to_photoFragment)
                R.id.bnbItemCollection -> replaceFragment(R.id.go_to_collectionFragment)
                R.id.bnbItemProfile -> replaceFragment(R.id.authFragment)
                else -> false
            }
        }

        KeyboardVisibilityEvent.setEventListener(
            this
        ) { isOpen ->
            if (isOpen) hideNavBar()
            else visibleNavBar()
        }
    }

    private fun replaceFragment(actionId: Int): Boolean {
        findNavController(R.id.maFragmentContainer).navigate(
            actionId,
            null,
            NavOptions.Builder().setPopUpTo(null, true).setLaunchSingleTop(true).build()
        )
        return true
    }

    override fun onNewIntent(intent: Intent) {
        val navFragment = supportFragmentManager.findFragmentById(R.id.maFragmentContainer)
        val fragment = navFragment?.childFragmentManager?.primaryNavigationFragment
        (fragment as? LoginFragment)?.onNewIntent(intent)
        intent.let { super.onNewIntent(it) }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return ZoomHelper.getInstance().dispatchTouchEvent(ev!!, this) || super.dispatchTouchEvent(
            ev
        )
    }

    fun hideNavBar() {
        binding?.maBottomBar?.visibility = View.GONE
    }

    fun visibleNavBar() {
        binding?.maBottomBar?.visibility = View.VISIBLE
    }
}
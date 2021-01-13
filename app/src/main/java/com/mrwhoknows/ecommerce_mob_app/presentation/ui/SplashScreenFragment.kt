package com.mrwhoknows.ecommerce_mob_app.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mrwhoknows.ecommerce_mob_app.R
import com.mrwhoknows.ecommerce_mob_app.presentation.theme.MyApplicationTheme
import com.mrwhoknows.ecommerce_mob_app.presentation.ui.user.UserViewModel
import com.mrwhoknows.ecommerce_mob_app.util.Tokens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            requireActivity().actionBar?.hide()

            setContent {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LinearProgressIndicator()
                    }
                }
            }
            isLoggedIn()
        }
    }

    private fun isLoggedIn() {
        val prefs = requireActivity().getSharedPreferences(Tokens.TOKEN_PREF, Context.MODE_PRIVATE)
        if (prefs.getString(Tokens.ACCESS, null).isNullOrEmpty())
            navigateTo(TargetFragment.LOGIN)
        else {
            navigateTo(TargetFragment.HOME)
        }

    }

    private fun navigateTo(target: TargetFragment) {
        when (target) {
            TargetFragment.LOGIN -> findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
            TargetFragment.HOME -> findNavController().navigate(R.id.action_splashScreenFragment_to_productListFragment)
        }
    }

    private enum class TargetFragment {
        LOGIN, HOME
    }
}
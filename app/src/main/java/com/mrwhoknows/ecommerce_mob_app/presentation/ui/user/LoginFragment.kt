package com.mrwhoknows.ecommerce_mob_app.presentation.ui.user

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mrwhoknows.ecommerce_mob_app.R
import com.mrwhoknows.ecommerce_mob_app.presentation.components.LoginForm
import com.mrwhoknows.ecommerce_mob_app.presentation.theme.MyApplicationTheme
import com.mrwhoknows.ecommerce_mob_app.util.Resource
import com.mrwhoknows.ecommerce_mob_app.util.Tokens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {

            setContent {
                MyApplicationTheme {
                    LoginForm(
                        userName = viewModel.username.value,
                        password = viewModel.password.value,
                        onUsernameChanged = viewModel::onUsernameChanged,
                        onPasswordChanged = viewModel::onPasswordChanged,
                        onLoginClicked = this@LoginFragment::onLoginClicked
                    )
                }
            }
        }
    }

    private fun onLoginClicked(email: String, password: String) {
        viewModel.loginUser(email, password)
        viewModel.tokens.observe(viewLifecycleOwner) { userTokensResource ->
            when (userTokensResource) {
                is Resource.Success -> {
                    val tokens = userTokensResource.data
                    tokens?.let {
                        findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
                        val prefs =
                            requireActivity().getSharedPreferences(Tokens.TOKEN_PREF, MODE_PRIVATE)
                        prefs.edit().apply {
                            putString(Tokens.ACCESS, tokens.access_token)
                            putString(Tokens.CSRF, tokens.csrf_token)
                            putString(Tokens.REFRESH, tokens.refresh_token)
                            apply()
                        }
                    }
                }
                is Resource.Error -> {
                    Snackbar.make(
                        requireView(),
                        userTokensResource.message.toString(),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                is Resource.Loading -> {
                    Snackbar.make(
                        requireView(),
                        "Loading",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
package com.mrwhoknows.ecommerce_mob_app.presentation.ui.product_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mrwhoknows.ecommerce_mob_app.presentation.components.ProductMetaCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private val viewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            viewModel.getProductList()
            setContent {
                val productMetaList = viewModel.productList.value

                if (productMetaList.isNotEmpty()) {

                    LazyColumn {
                        items(items = productMetaList) { productMeta ->
                            ProductMetaCard(
                                productMeta = productMeta,
                                this@ProductListFragment::navigateToProductFragment
                            )
                        }
                    }

                }
            }
        }
    }

    private fun navigateToProductFragment(id: String) {
        findNavController().navigate(
            ProductListFragmentDirections.actionProductListFragmentToProductFragment(
                id
            )
        )
    }
}
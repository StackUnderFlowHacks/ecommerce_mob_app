package com.mrwhoknows.ecommerce_mob_app.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mrwhoknows.ecommerce_mob_app.domain.model.Product
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ProductDetails(product: Product) {
    Column(modifier = Modifier.padding(4.dp)) {
        CoilImage(
            data = product.thumbnail,
            fadeIn = true,
            modifier = Modifier
                .fillMaxWidth()
                .preferredHeight(300.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            modifier = Modifier.padding(4.dp), text = product.name, fontSize = TextUnit.Sp(24)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            modifier = Modifier.padding(4.dp),
            text = "Price: ${product.price}",
            fontSize = TextUnit.Sp(22)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            modifier = Modifier.padding(4.dp),
            text = product.description, fontSize = TextUnit.Sp(20)
        )
    }
}
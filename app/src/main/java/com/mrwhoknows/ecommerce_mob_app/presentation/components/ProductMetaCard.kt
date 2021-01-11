package com.mrwhoknows.ecommerce_mob_app.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mrwhoknows.ecommerce_mob_app.domain.model.ProductMeta
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ProductMetaCard(
    productMeta: ProductMeta,
    onCardClick: (String) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = 10.dp,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(onClick = { onCardClick(productMeta.productId.toString()) })
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            CoilImage(
                data = productMeta.thumbnail,
                fadeIn = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(230.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = productMeta.name, fontSize = TextUnit.Sp(22))
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Price: ${
                    productMeta.price
                }", fontSize = TextUnit.Sp(20)
            )
        }
    }
}
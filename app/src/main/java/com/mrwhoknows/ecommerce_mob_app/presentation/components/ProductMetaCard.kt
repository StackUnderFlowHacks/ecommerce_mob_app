package com.mrwhoknows.ecommerce_mob_app.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mrwhoknows.ecommerce_mob_app.domain.model.ProductMeta
import com.mrwhoknows.ecommerce_mob_app.presentation.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlin.math.roundToInt

@Composable
fun ProductMetaCard(
    productMeta: ProductMeta,
    onCardClick: (String) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 10.dp,
        modifier = Modifier
            .preferredHeight(200.dp)
            .padding(horizontal = 8.dp, vertical = 1.dp)
            .clickable(onClick = { onCardClick(productMeta.productId.toString()) }),
    ) {

        Row(modifier = Modifier.fillMaxHeight()) {
            CoilImage(
                data = productMeta.thumbnail,
                fadeIn = true,
                modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .fillMaxHeight(),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = productMeta.name,
                    fontSize = TextUnit.Sp(18),
                    maxLines = 3
                )
                Text(
                    text = productMeta.brand,
                    fontWeight = FontWeight.Light,
                    fontSize = TextUnit.Sp(16)
                )
                Surface(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape),
                ) {
                    Text(
                        text = "${productMeta.rating} ⭐",
                        modifier = Modifier.padding(vertical = 3.dp, horizontal = 12.dp),
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontStyle = typography.caption.fontStyle
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                ) {
                    Text(
                        text = "₹ ${productMeta.price}",
                        style = typography.h5.copy(fontWeight = FontWeight.Medium),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
//                    TODO: change it (should be done on backend)
                    val originalAmount =
                        ((productMeta.price) * 100) / (100 - (productMeta.discount)).roundToInt()
                    Text(
                        text = "₹ $originalAmount",
                        textDecoration = TextDecoration.LineThrough,
                        fontWeight = FontWeight.ExtraLight,
                        fontSize = TextUnit.Sp(16),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 8.dp)
                    )
                    Text(
                        text = "${productMeta.discount.toInt()}% off",
                        fontWeight = FontWeight.Medium,
                        fontSize = TextUnit.Sp(14),
                        color = Color.Green,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 2.dp)
                    )
                }
                Text(
                    text = productMeta.paymentOption,
                    modifier = Modifier.padding(vertical = 4.dp),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontStyle = typography.caption.fontStyle
                    )
                )
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ProductMetaCard(
        productMeta = ProductMeta(
            productId = 1,
            name = "Asus Tuf Gaming Laptop FX505DT Ryzen 5 3500H, 8GB Ram, 128GB SSD, 1TB HDD, 4GB Nvidia GTX 1650 Graphics Card",
            productSlug = "asus-tuf-gaming-laptop-fx505dt-ryzen-5-3500h-8gb-ram-128gb-ssd-1tb-hdd-4gb-nvidia-gtx-1650-graphics-card-3at28j3bkB5V",
            price = 53451,
            manufacturer = "Asus, TECH FRONT ( CHONGQING) Computer Co. Ltd, NO 18 , Zongbao Road, Shapingba Dist,Chongquing, China",
            thumbnail = "https://images-na.ssl-images-amazon.com/images/I/815K4p82zlL._SL1500_.jpg",
            stock = 399,
            isInStock = true,
            paymentOption = "Cash On Delivery",
            rating = 4.3,
            brand = "Asus Infotech",
            discount = 15.0
        ),
        onCardClick = { }
    )
}
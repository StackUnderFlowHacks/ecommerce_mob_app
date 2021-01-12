package com.mrwhoknows.ecommerce_mob_app.presentation.components

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.mrwhoknows.ecommerce_mob_app.domain.model.Product
import com.mrwhoknows.ecommerce_mob_app.presentation.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ProductDetails(product: Product) {
    ScrollableColumn(modifier = Modifier.padding(8.dp)) {

        ScrollableRow(modifier = Modifier.padding(2.dp)) {
            product.photos.forEach {
                CoilImage(
                    data = it!!,
                    fadeIn = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(300.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            modifier = Modifier.padding(4.dp),
            text = product.name,
            fontSize = TextUnit.Sp(20)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clip(CircleShape)
        ) {
            Text(
                text = "${product.rating} ⭐",
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontStyle = typography.caption.fontStyle
                )
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
        ) {
            Text(
                text = "₹ ${product.price}",
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit.Sp(24),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            val originalAmount =
                product.price + ((product.price) * (product.discount.toFloat() / 100))
            Text(
                text = "($originalAmount)",
                textDecoration = TextDecoration.LineThrough,
                fontWeight = FontWeight.ExtraLight,
                fontSize = TextUnit.Sp(16),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            modifier = Modifier.padding(4.dp),
            text = product.description, fontSize = TextUnit.Sp(16)
        )
    }
}

val product = Product(
    productId = 1,
    name = "Asus Tuf Gaming Laptop FX505DT Ryzen 5 3500H, 8GB Ram, 128GB SSD, 1TB HDD, 4GB Nvidia GTX 1650 Graphics Card",
    productSlug = "asus-tuf-gaming-laptop-fx505dt-ryzen-5-3500h-8gb-ram-128gb-ssd-1tb-hdd-4gb-nvidia-gtx-1650-graphics-card-3at28j3bkB5V",
    price = 53451,
    manufacturer = "Asus, TECH FRONT ( CHONGQING) Computer Co. Ltd, NO 18 , Zongbao Road, Shapingba Dist,Chongquing, China",
    thumbnail = "https://images-na.ssl-images-amazon.com/images/I/815K4p82zlL._SL1500_.jpg",
    stock = 399,
    isInStock = true,
    paymentOption = "Online",
    categories = listOf("smart phone", "android"),
    countryOfOrigin = "Error",
    coupons = listOf("REDRED2020"),
    discount = "12.00",
    description = "Quad camera setup - 64MP (F1.8) main camera + 12MP (F2.2) ultra wide camera + 5MP (F2.4) depth camera + 5MP (F2.4) macro camera and 32MP (F2.2) front camera\n16.95 cm (6.7-inch) sAMOLED Plus - Infinity-O display, FHD+ capacitive touchscreen with 1080 x 2400 pixels resolution, Contrast Ratio: 78960:1\nMemory, Storage & SIM: 8GB RAM, 128GB internal memory expandable up to 512GB | Dedicated Memory slot\nAndroid v10.0 operating system with 2.2GHz+1.8GHz Qualcomm | SD730G octa core processor\n7000mAH lithium-ion battery | 25W USB Type-C to C fast charger in the box\nFast face unlock and Side Fingerprint sensor | Dual SIM (nano+nano) with dual standby and dual VoLTE | 3.5 mm headphone jack\n1 year manufacturer warranty for device and 6 months manufacturer warranty for in-box accessories including batteries from the date of purchase\nBox also includes: Travel adapter, USB Type-C to C, ejection pin and user manual",
    photos = listOf(
        "https://images-na.ssl-images-amazon.com/images/I/713AhSUtbHL._SL1500_.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/81h7bygApVL._SL1500_.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/71b9jSJRh4L._SL1500_.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/71EtDfaueuL._SL1500_.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/61FTNumOURL._SL1500_.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/51u%2BTohyJhL._SL1500_.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/51oWwx6sFHL._SL1500_.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/71V0G2dj%2BIL._SL1500_.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/71cI4nAx4fL._SL1500_.jpg"
    ),
    rating = "4.4"
)

@Preview(showBackground = true)
@Composable
fun ProductPreview() {
    ProductDetails(product = product)
}
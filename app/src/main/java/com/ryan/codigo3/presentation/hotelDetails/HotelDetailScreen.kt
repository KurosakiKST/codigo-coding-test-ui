package com.ryan.codigo3.presentation.hotelDetails

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryan.codigo3.R
import com.ryan.codigo3.presentation.common.components.AmenityRow
import com.ryan.codigo3.presentation.common.components.ImageSlide
import com.ryan.codigo3.presentation.common.components.ImageSlider
import com.ryan.codigo3.presentation.common.components.MembersDealsTag
import com.ryan.codigo3.presentation.common.components.RoomTabType
import com.ryan.codigo3.presentation.common.components.RoomTabs
import com.ryan.codigo3.presentation.common.components.SpecialFeature
import com.ryan.codigo3.presentation.common.components.VoucherCard
import com.ryan.codigo3.presentation.common.components.hotelAmenities
import com.ryan.codigo3.presentation.common.theme.CodigoTheme
import com.ryan.codigo3.presentation.common.theme.Red

@Composable
fun HotelDetailScreen() {
    var selectedTab by remember { mutableStateOf(RoomTabType.BY_ROOM) }

    // Sample hotel images for the slider
    val hotelImages = remember {
        listOf(
            ImageSlide(R.drawable.image_1, "Hotel Front View"),
            ImageSlide(R.drawable.image_2, "Hotel Pool"),
            ImageSlide(R.drawable.image_3, "Hotel Lobby"),
            ImageSlide(R.drawable.image_4, "Hotel Restaurant")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        // Hotel Header with image slider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        ) {
            // Image Slider
            ImageSlider(
                images = hotelImages,
                modifier = Modifier.fillMaxSize()
            )

            // Back button
            Surface(
                shape = CircleShape,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .size(40.dp)
                    .align(Alignment.TopStart)
                    .clickable { /* Handle back navigation */ }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Red,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp)
                )
            }

            // Interaction Icons (Currency, Chat)
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopEnd),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* Handle currency click */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.currency),
                        contentDescription = "Currency",
                        tint = Red,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(24.dp)
                    )
                }

                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* Handle chat click */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.chatactive),
                        contentDescription = "Chat",
                        tint = Red,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(24.dp)
                    )
                }
            }
        }

        // Hotel title and location
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Furama Riverfront, Singapore",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Icon(
                    painter = painterResource(id = R.drawable.nextred),
                    contentDescription = "View Details",
                    tint = Red,
                    modifier = Modifier.size(20.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.currentlocation),
                    contentDescription = "Location",
                    tint = Red,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "405 Havelock Road, Singapore 169633",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.currentlocation),
                    contentDescription = "Map View",
                    tint = Red,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )
            }
        }

        // Amenities row with icons
        AmenityRow(amenities = hotelAmenities)

        Spacer(modifier = Modifier.height(16.dp))

        // Room tabs
        RoomTabs(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Content based on selected tab
        AnimatedVisibility(
            visible = selectedTab == RoomTabType.BY_ROOM,
            enter = fadeIn(animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(300))
        ) {
            // Room view content
            Column {
                // Deluxe Twin room card
                RoomCard(
                    roomName = "Deluxe Twin",
                    description = "Twin Single Beds, Cable TV, Free Wifi...",
                    price = "SGD 161.42",
                    imageResId = R.drawable.image_3
                )

                // Additional room options could be added here
                RoomCard(
                    roomName = "Superior King",
                    description = "King Bed, City View, Free WiFi, Minibar...",
                    price = "SGD 182.50",
                    imageResId = R.drawable.image_2
                )
            }
        }

        AnimatedVisibility(
            visible = selectedTab == RoomTabType.BY_RATES,
            enter = fadeIn(animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(300))
        ) {
            // Rates view content
            Column {
                // Special voucher
                VoucherCard(
                    title = "Mobile App Special Voucher",
                    price = "SGD 161.42",
                    specialFeatures = listOf(
                        SpecialFeature(R.drawable.fnb, "Inclusive of Breakfast"),
                        SpecialFeature(R.drawable.discount, "20% off In-Room Service")
                    ),
                    onViewRatesClick = { /* Handle click */ }
                )

                // Member deals tag
                MembersDealsTag()

                // Weekend staycation voucher
                VoucherCard(
                    title = "Weekend Staycation",
                    price = "SGD 161.42",
                    specialFeatures = listOf(
                        SpecialFeature(R.drawable.fnb, "Inclusive of Breakfast"),
                        SpecialFeature(R.drawable.discount, "20% off In-Room Service")
                    ),
                    onViewRatesClick = { /* Handle click */ }
                )
            }
        }

        // Bottom spacing
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun RoomCard(
    roomName: String,
    description: String,
    price: String,
    imageResId: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Room image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                androidx.compose.foundation.Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = roomName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Room details
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    // Room title
                    Text(
                        text = roomName,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )

                    // Room description
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }

                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color.White,
                    border = androidx.compose.foundation.BorderStroke(1.dp, Red),
                    modifier = Modifier.clickable { /* Handle view rates click */ }
                ) {
                    Text(
                        text = "View Rates",
                        style = MaterialTheme.typography.labelMedium,
                        color = Red,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }

            // Room price
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text(
                    text = "Avg. Nightly / Room From",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Text(
                    text = price,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun HotelDetailScreenPreview() {
    CodigoTheme {
        HotelDetailScreen()
    }
}
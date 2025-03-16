package com.ryan.codigo3.presentation.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ryan.codigo3.R

data class AmenityItem(
    val iconResId: Int,
    val label: String,
    val onClick: () -> Unit = {}
)

@Composable
fun AmenityRow(amenities: List<AmenityItem>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        amenities.forEach { amenity ->
            AmenityIcon(
                iconResId = amenity.iconResId,
                label = amenity.label,
                onClick = amenity.onClick
            )
        }
    }
}

@Composable
fun AmenityIcon(
    iconResId: Int,
    label: String,
    tint: Color = Color.Gray,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = label,
            tint = tint,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = tint,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

// Predefined hotel amenities
val hotelAmenities = listOf(
    AmenityItem(R.drawable.theme, "Amenities"),
    AmenityItem(R.drawable.wifi, "Facilities"),
    AmenityItem(R.drawable.fnb, "F&B"),
    AmenityItem(R.drawable.kidsfamily, "Kids/Family"),
    AmenityItem(R.drawable.wellness, "Wellness")
)
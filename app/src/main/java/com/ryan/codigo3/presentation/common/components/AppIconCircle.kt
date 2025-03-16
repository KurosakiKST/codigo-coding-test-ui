package com.ryan.codigo3.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ryan.codigo3.R

@Composable
fun AppIconCircle(
    iconResId: Int,
    contentDescription: String?,
    tint: Color = Color.Unspecified,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    size: Int = 40
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.size((size * 0.6).dp)
        )
    }
}

@Composable
fun AppIconRounded(
    iconResId: Int,
    contentDescription: String?,
    tint: Color = Color.Unspecified,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    size: Int = 40,
    cornerRadius: Int = 8
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(RoundedCornerShape(cornerRadius.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.size((size * 0.6).dp)
        )
    }
}

object AppIcons {
    // Define icon resource IDs for all the icons
    val Workout = R.drawable.workout
    val Wifi = R.drawable.wifi
    val Wellness = R.drawable.wellness
    val Tv = R.drawable.tv
    val Theme = R.drawable.theme
    val Pay = R.drawable.pay
    val NextRed = R.drawable.nextred
    val Minus = R.drawable.minus
    val KidsFamily = R.drawable.kidsfamily
    val Iron = R.drawable.iron
    val Generic = R.drawable.generic
    val Fnb = R.drawable.fnb
    val Discount = R.drawable.discount
    val CurrentLocation = R.drawable.currentlocation
    val Currency = R.drawable.currency
    val ChatActive = R.drawable.chatactive
    val Call = R.drawable.call
    val Add = R.drawable.add
}
package com.ryan.codigo3.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ryan.codigo3.presentation.common.theme.LightGray
import com.ryan.codigo3.presentation.common.theme.Red

@Composable
fun RoomTabs(
    selectedTab: RoomTabType,
    onTabSelected: (RoomTabType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 16.dp)
            .background(LightGray, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
    ) {
        RoomTabType.values().forEach { tabType ->
            RoomTabItem(
                tabType = tabType,
                isSelected = selectedTab == tabType,
                onTabSelected = { onTabSelected(tabType) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun RoomTabItem(
    tabType: RoomTabType,
    isSelected: Boolean,
    onTabSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected) Red else Color.Transparent
    val contentColor = if (isSelected) Color.White else Color.Gray

    Surface(
        shape = RoundedCornerShape(8.dp),
        color = backgroundColor,
        onClick = onTabSelected,
        modifier = modifier
            .padding(4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = tabType.title,
                style = MaterialTheme.typography.bodyMedium,
                color = contentColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

enum class RoomTabType(val title: String) {
    BY_ROOM("By Room"),
    BY_RATES("By Rates")
}
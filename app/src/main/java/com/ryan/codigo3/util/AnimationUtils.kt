package com.ryan.codigo3.util

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

/**
 * Animation utilities for screen transitions and UI animations
 */
object AnimationUtils {
    // Default duration for animations
    const val DEFAULT_ANIMATION_DURATION = 300

    // Animation spec for smooth transitions
    val defaultAnimationSpec: AnimationSpec<Float> = tween(
        durationMillis = DEFAULT_ANIMATION_DURATION,
        easing = FastOutSlowInEasing
    )

    // Slide in animation calculation
    fun calculateSlideInHorizontalOffset(initialOffsetX: Float, width: Int): IntOffset {
        return IntOffset((width * initialOffsetX).roundToInt(), 0)
    }

    // Fade transition animation spec
    val fadeAnimationSpec: AnimationSpec<Float> = tween(
        durationMillis = DEFAULT_ANIMATION_DURATION,
        easing = FastOutSlowInEasing
    )
}
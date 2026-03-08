package com.uncannyvalley.coursengine.core.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.uncannyvalley.coursengine.core.presentation.theme.ElectricLime
import courseengine.composeapp.generated.resources.Res
import courseengine.composeapp.generated.resources.ic_heart
import courseengine.composeapp.generated.resources.ic_heart_filled
import org.jetbrains.compose.resources.painterResource

@Composable
fun FavoriteIcon(
    isFavorite: Boolean,
    modifier: Modifier = Modifier
) {
    val tint by animateColorAsState(
        targetValue = if (isFavorite) ElectricLime else Color.Unspecified,
        animationSpec = tween(durationMillis = 300),
        label = "favorite_color"
    )

    val scale = remember { Animatable(1f) }
    var firstLaunch by remember { mutableStateOf(true) }

    LaunchedEffect(isFavorite) {
        if (firstLaunch) {
            firstLaunch = false
            return@LaunchedEffect
        }

        scale.animateTo(1.3f, animationSpec = tween(120))
        scale.animateTo(1f, animationSpec = tween(120))
    }

    val iconPainter = painterResource(
        resource = if (!isFavorite) Res.drawable.ic_heart else Res.drawable.ic_heart_filled
    )

    Icon(
        painter = iconPainter,
        contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
        modifier = modifier
            .graphicsLayer(scaleX = scale.value, scaleY = scale.value),
        tint = tint
    )
}
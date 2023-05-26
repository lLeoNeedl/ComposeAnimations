package com.sumin.composeanimations.ui.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sumin.composeanimations.ui.theme.Purple500

@Composable
fun Test() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(
                state = rememberScrollState(),
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val isIncreased = remember {
            mutableStateOf(true)
        }
        val size by animateDpAsState(targetValue = if (isIncreased.value) 200.dp else 100.dp)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isIncreased.value = !isIncreased.value }
        ) {
            Text(
                text = "Animate size",
            )
        }
        AnimatedContainer(
            text = "Size",
            size = size
        )

        var isRounded by remember {
            mutableStateOf(false)
        }
        val radius by animateIntAsState(targetValue = if (!isRounded) 4 else 50)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isRounded = !isRounded }
        ) {
            Text(
                text = "Animate shape"
            )
        }
        AnimatedContainer(
            text = "Shape",
            radiusPercent = radius
        )

        var hasBorder by remember {
            mutableStateOf(false)
        }
        val borderWidth by animateDpAsState(targetValue = if (hasBorder) 8.dp else 0.dp)
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { hasBorder = !hasBorder }
        ) {
            Text(
                text = "Animate border",
            )
        }
        AnimatedContainer(
            text = "Border",
            width = borderWidth
        )

        var isColorChanged by remember {
            mutableStateOf(false)
        }
        val color by animateColorAsState(targetValue = if (isColorChanged) Color.Magenta else Color.Blue)
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isColorChanged = !isColorChanged }
        ) {
            Text(
                text = "Animate color",
            )
        }
        AnimatedContainer(
            text = "Color",
            color = color
        )

        var isTransparent by remember {
            mutableStateOf(false)
        }
        val alpha by animateFloatAsState(targetValue = if (isTransparent) 0F else 1F)
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isTransparent = !isTransparent }
        ) {
            Text(
                text = "Animate visibility",
            )
        }
        AnimatedContainer(
            text = "Visibility",
            alpha = alpha
        )
    }
}

@Composable
private fun AnimatedContainer(
    text: String,
    size: Dp = 200.dp,
    radiusPercent: Int = 4,
    width: Dp = 0.dp,
    color: Color = Color.Blue,
    alpha: Float = 1F
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(radiusPercent))
            .alpha(alpha)
            .border(width = width, color = Color.Black)
            .background(color)
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}

package com.uncannyvalley.coursengine.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.uncannyvalley.coursengine.core.presentation.theme.CourseEngineTheme
import courseengine.composeapp.generated.resources.Res
import courseengine.composeapp.generated.resources.ic_close
import courseengine.composeapp.generated.resources.ic_search
import org.jetbrains.compose.resources.painterResource

@Composable
fun ExpandableSearchFab(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }

    BoxWithConstraints(modifier = modifier) {
        val maxAllowedWidth = 480.dp

        val expandedWidth = min(maxWidth, maxAllowedWidth)
        val collapsedWidth = 56.dp

        val width by animateDpAsState(
            targetValue = if (expanded) expandedWidth else collapsedWidth,
            label = "searchWidth"
        )

        Surface(
            modifier = modifier.height(56.dp).width(width),
            shape = RoundedCornerShape(28.dp),
            border = BorderStroke(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onBackground
            ),
            color = MaterialTheme.colorScheme.secondary
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .width(56.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = { expanded = !expanded }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_search),
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }

                AnimatedVisibility(expanded) {
                    TextField(
                        value = query,
                        onValueChange = {
                            query = it
                            onSearch(it)
                        },
                        placeholder = { Text("Search...") },
                        singleLine = true,
                        trailingIcon = {
                            if (query.isNotEmpty()) {
                                IconButton(
                                    onClick = { query = "" },
                                    modifier = Modifier
                                        .size(14.dp)
                                        .offset(x = (10).dp)
                                ) {
                                    Icon(
                                        painter = painterResource(Res.drawable.ic_close),
                                        contentDescription = "Clear",
                                        tint = MaterialTheme.colorScheme.onSecondary
                                    )
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(x = (-16).dp),
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                            focusedContainerColor = MaterialTheme.colorScheme.secondary,
                            unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                            disabledContainerColor = MaterialTheme.colorScheme.secondary,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ExpandableSearchFabPreview() {
    CourseEngineTheme {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            ExpandableSearchFab(onSearch = {})
        }
    }
}

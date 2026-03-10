package com.uncannyvalley.coursengine.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.coursengine.core.presentation.theme.BlackOlive
import com.uncannyvalley.coursengine.core.presentation.theme.CourseEngineTheme
import courseengine.composeapp.generated.resources.Res
import courseengine.composeapp.generated.resources.course_cover_example
import courseengine.composeapp.generated.resources.ic_clock
import courseengine.composeapp.generated.resources.ic_star
import courseengine.composeapp.generated.resources.ic_student
import org.jetbrains.compose.resources.painterResource

@Composable
fun CourseCard(
    modifier: Modifier = Modifier,
    title: String,
    author: String,
    rating: Double,
    students: Int,
    hours: Int,
    price: String,
    imagePainter: Painter,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    val shape = RoundedCornerShape(25.dp)
    val strokeColor = MaterialTheme.colorScheme.onBackground

    val cornerRadius = 25.dp
    val strokeWidth = 1.5.dp

    Card(
        modifier = modifier.height(180.dp)
            .drawWithContent {
                drawContent()

                val strokePx = strokeWidth.toPx()
                val halfStroke = strokePx / 2

                drawRoundRect(
                    color = strokeColor,
                    topLeft = Offset(halfStroke, halfStroke),
                    size = Size(
                        size.width - strokePx,
                        size.height - strokePx
                    ),
                    cornerRadius = CornerRadius(cornerRadius.toPx()),
                    style = Stroke(
                        width = strokePx,
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(24f, 22f)
                        )
                    )
                )
            },
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp)
                    .padding(end = 100.dp) // reserve space for image
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = author,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InfoItem(
                        icon = painterResource(Res.drawable.ic_star),
                        text = rating.toString()
                    )

                    Spacer(Modifier.width(7.dp))

                    InfoItem(
                        icon = painterResource(Res.drawable.ic_student),
                        text = students.toString()
                    )

                    Spacer(Modifier.width(7.dp))

                    InfoItem(
                        icon = painterResource(Res.drawable.ic_clock),
                        text = "$hours h"
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(20.dp)
                    .size(92.dp)
            ) {

                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(92.dp)
                        .height(85.dp)
                        .clip(RoundedCornerShape(15.dp))
                )

                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
                    FavoriteIcon(
                        isFavorite,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(23.dp)
                    .border(
                        width = 1.dp,
                        color = BlackOlive,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = price,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CourseCardPreview() {
    CourseEngineTheme(darkTheme = false) {
        CourseCard(
            title = "PRO SQL",
            imagePainter = painterResource(Res.drawable.course_cover_example),
            author = "Иосиф Дзеранов",
            price = "8900",
            rating = 5.0,
            students = 100,
            hours = 2,
            isFavorite = false,
            onFavoriteClick = {}
        )
    }
}

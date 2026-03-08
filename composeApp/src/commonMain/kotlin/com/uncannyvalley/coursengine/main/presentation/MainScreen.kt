package com.uncannyvalley.coursengine.main.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uncannyvalley.coursengine.core.presentation.components.CourseCard
import com.uncannyvalley.coursengine.core.presentation.components.ExpandableSearchFab
import courseengine.composeapp.generated.resources.Res
import courseengine.composeapp.generated.resources.course_cover_example
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreen(
    coursesViewModel: CoursesViewModel = viewModel()
) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                columns = GridCells.Adaptive(340.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item(
                    key = "header",
                    span = { GridItemSpan(maxLineSpan) }
                ) {
                    Text(
                        text = "New Courses",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(top = 80.dp, bottom = 8.dp)
                    )
                }
                items(
                    items = coursesViewModel.courses,
                    key = { it.id }
                ) { course ->
                    val onFavoriteClick = remember(course.id) {
                        { coursesViewModel.toggleFavorite(course.id) }
                    }
                    CourseCard(
                        modifier = Modifier.fillMaxWidth(),
                        title = course.title,
                        author = course.author,
                        rating = course.rating,
                        students = course.students,
                        hours = course.hours,
                        price = course.price,
                        imagePainter = painterResource(Res.drawable.course_cover_example),
                        isFavorite = coursesViewModel.isFavorite(course.id),
                        onFavoriteClick = onFavoriteClick
                    )
                }
            }

        }
    }
}

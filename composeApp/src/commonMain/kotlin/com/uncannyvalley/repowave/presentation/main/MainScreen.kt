package com.uncannyvalley.repowave.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uncannyvalley.repowave.presentation.components.CourseCard
import myproject.composeapp.generated.resources.Res
import myproject.composeapp.generated.resources.course_cover_example
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreen(
    coursesViewModel: CoursesViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp)
    ) {
        // title
        Text(
            text = "New Courses",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 52.dp, bottom = 26.dp)
        )

        // course list
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(
                items = coursesViewModel.courses,
                key = { it.id }
            ) { course ->

                CourseCard(
                    title = course.title,
                    author = course.author,
                    rating = course.rating,
                    students = course.students,
                    hours = course.hours,
                    price = course.price,
                    imagePainter = painterResource(Res.drawable.course_cover_example),
                    isFavorite = coursesViewModel.isFavorite(course.id),
                    onFavoriteClick = { coursesViewModel.toggleFavorite(course.id) }
                )
            }
        }
    }
}
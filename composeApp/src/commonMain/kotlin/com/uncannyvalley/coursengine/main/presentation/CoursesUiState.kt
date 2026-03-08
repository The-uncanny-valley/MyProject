package com.uncannyvalley.coursengine.main.presentation

import com.uncannyvalley.coursengine.main.domain.Course

data class CoursesUiState(
    val courses: List<Course> = emptyList(),
    val favorites: Set<Int> = emptySet(),
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)

fun CoursesUiState.isFavorite(courseId: Int): Boolean = favorites.contains(courseId)

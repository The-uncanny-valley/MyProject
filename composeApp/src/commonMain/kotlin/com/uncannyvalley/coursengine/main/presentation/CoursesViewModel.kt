package com.uncannyvalley.coursengine.main.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uncannyvalley.coursengine.main.data.CourseRepositoryImpl
import com.uncannyvalley.coursengine.main.domain.Course
import com.uncannyvalley.coursengine.main.domain.CoursesRepository
import kotlinx.coroutines.launch

class CoursesViewModel(
    private val repository: CoursesRepository = CourseRepositoryImpl()
) : ViewModel() {

    var courses by mutableStateOf<List<Course>>(emptyList())
        private set

    var favorites by mutableStateOf<Set<Int>>(emptySet())
        private set

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            val result = repository.getCourses()
            result.getOrNull()?.let {
                courses = it
            }
        }
    }

    fun toggleFavorite(courseId: Int) {
        favorites = if (favorites.contains(courseId)) {
            favorites - courseId
        } else {
            favorites + courseId
        }
    }

    fun isFavorite(courseId: Int): Boolean = favorites.contains(courseId)
}
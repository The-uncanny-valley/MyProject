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

    var uiState by mutableStateOf(CoursesUiState())
        private set

    var courses by mutableStateOf<List<Course>>(emptyList())
        private set

    var favorites by mutableStateOf<Set<Int>>(emptySet())
        private set

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            val result = repository.getCourses()
            result.getOrNull()?.let {
                courses = it
            }
            uiState = uiState.copy(
                courses = result.getOrNull() ?: emptyList(),
                isLoading = false
            )
        }
    }

    fun toggleFavorite(courseId: Int) {
        val currentFavorites = uiState.favorites
        val newFavorites = if (currentFavorites.contains(courseId)) {
            currentFavorites - courseId
        } else {
            currentFavorites + courseId
        }
        uiState = uiState.copy(favorites = newFavorites)
    }

    fun isFavorite(courseId: Int): Boolean = uiState.favorites.contains(courseId)
}
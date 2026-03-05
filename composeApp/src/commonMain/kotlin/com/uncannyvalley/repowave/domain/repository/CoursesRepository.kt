package com.uncannyvalley.repowave.domain.repository

import com.uncannyvalley.repowave.domain.model.Course

interface CoursesRepository {
    suspend fun getCourses(): Result<List<Course>>
}
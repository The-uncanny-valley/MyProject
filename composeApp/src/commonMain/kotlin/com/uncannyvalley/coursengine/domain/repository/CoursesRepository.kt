package com.uncannyvalley.coursengine.domain.repository

import com.uncannyvalley.coursengine.domain.model.Course

interface CoursesRepository {
    suspend fun getCourses(): Result<List<Course>>
}
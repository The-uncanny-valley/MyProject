package com.uncannyvalley.coursengine.main.domain

interface CoursesRepository {
    suspend fun getCourses(): Result<List<Course>>
}
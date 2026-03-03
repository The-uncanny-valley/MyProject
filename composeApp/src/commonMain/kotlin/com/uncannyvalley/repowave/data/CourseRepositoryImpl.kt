package com.uncannyvalley.repowave.data

import com.uncannyvalley.repowave.domain.model.Course
import com.uncannyvalley.repowave.domain.repository.CoursesRepository

class CourseRepositoryImpl : CoursesRepository {
    override suspend fun getCourses(): Result<List<Course>> {
        return Result.success(
            listOf(
                Course(
                    id = 1,
                    title = "Linear Algebra",
                    summary = "Learn Algebra.",
                    coverUrl = null,
                    author = "Computer Science Center",
                    price = 800.0,
                    rating = 4.2,
                    hours = 8,
                    students = 1201
                ),
                Course(
                    id = 2,
                    title = "English for IT & Computer Science",
                    summary = "Learn English",
                    coverUrl = null,
                    author = "A. Andreeva",
                    price = 300.0,
                    rating = 4.6,
                    hours = 5,
                    students = 289
                ),
                Course(
                    id = 3,
                    title = "PRO SQL",
                    summary = "Master problem solving.",
                    coverUrl = null,
                    author = "Иосиф Дзеранов, Кирилл Фисенко",
                    price = 8900.0,
                    rating = 5.0,
                    hours = 120,
                    students = 1678
                )
            )
        )
    }
}
package com.uncannyvalley.coursengine.main.data

import com.uncannyvalley.coursengine.main.domain.Course
import com.uncannyvalley.coursengine.main.domain.CoursesRepository

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
                    author = "Иосиф Дзеранов",
                    price = 8900.0,
                    rating = 5.0,
                    hours = 120,
                    students = 1678
                ),
                Course(
                    id = 4,
                    title = "PRO SQL2",
                    summary = "Master problem solving.",
                    coverUrl = null,
                    author = "Иосиф Дзеранов",
                    price = 8900.0,
                    rating = 5.0,
                    hours = 120,
                    students = 1678
                ),
                Course(
                    id = 5,
                    title = "PRO SQL3",
                    summary = "Master problem solving.",
                    coverUrl = null,
                    author = "Иосиф Дзеранов",
                    price = 8900.0,
                    rating = 5.0,
                    hours = 120,
                    students = 1678
                ),
                Course(
                    id = 6,
                    title = "PRO SQL",
                    summary = "Master problem solving.",
                    coverUrl = null,
                    author = "Иосиф Дзеранов",
                    price = 8900.0,
                    rating = 5.0,
                    hours = 120,
                    students = 1678
                )
            )
        )
    }
}
package com.uncannyvalley.coursengine.main.data

import com.uncannyvalley.coursengine.data.network.NetworkClient
import com.uncannyvalley.coursengine.main.domain.Course
import com.uncannyvalley.coursengine.main.domain.CoursesRepository
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class CourseRepositoryImpl : CoursesRepository {
    override suspend fun getCourses(): Result<List<Course>> {
        return try {
            val response: StepikResponse = NetworkClient.httpClient.get("https://stepik.org/api/courses") {
                parameter("is_public", "true")
                parameter("order", "-id")
            }.body()

            val domainCourses = response.courses.map { dto ->
                Course(
                    id = dto.id,
                    title = dto.title,
                    summary = dto.summary,
                    coverUrl = dto.cover,
                    author = "Stepik",
                    price = parsePrice(dto.displayPrice),
                    rating = 0.0,
                    hours = (dto.timeToComplete ?: 0) / 3600,
                    students = dto.learnersCount
                )
            }
            Result.success(domainCourses)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun parsePrice(displayPrice: String?): String {
        if (displayPrice == null || displayPrice.lowercase() == "free") return "free"
        return displayPrice.replace(Regex("[^0-9.]"), "")
    }
}

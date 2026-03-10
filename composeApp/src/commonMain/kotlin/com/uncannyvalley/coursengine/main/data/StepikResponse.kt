package com.uncannyvalley.coursengine.main.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StepikResponse(
    val meta: Meta,
    val courses: List<CourseDto>
)

@Serializable
data class Meta(
    val page: Int,
    @SerialName("has_next")
    val hasNext: Boolean,
    @SerialName("has_previous")
    val hasPrevious: Boolean
)

@Serializable
data class CourseDto(
    val id: Int,
    val title: String,
    val summary: String,
    val cover: String? = null,
    @SerialName("learners_count")
    val learnersCount: Int = 0,
    @SerialName("review_summary")
    val reviewSummary: Int? = null,
    @SerialName("display_price")
    val displayPrice: String? = null,
    @SerialName("time_to_complete")
    val timeToComplete: Int? = null
)

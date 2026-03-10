package com.uncannyvalley.coursengine.main.domain

data class Course(
    val id: Int,
    val title: String,
    val summary: String,
    val author: String,
    val price: String,
    val rating: Double,
    val hours: Int,
    val students: Int,
    val coverUrl: String?
)
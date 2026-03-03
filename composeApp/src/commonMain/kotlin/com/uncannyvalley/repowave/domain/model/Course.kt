package com.uncannyvalley.repowave.domain.model

data class Course(
    val id: Int,
    val title: String,
    val summary: String,
    val author: String,
    val price: Double,
    val rating: Double,
    val coverUrl: String?
)
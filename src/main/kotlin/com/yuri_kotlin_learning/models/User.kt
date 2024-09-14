package com.yuri_kotlin_learning.models

import java.time.LocalDate
import java.util.*

data class User(val name: String, val dateOfBirth: LocalDate) {
    val id: UUID = UUID.randomUUID()
}

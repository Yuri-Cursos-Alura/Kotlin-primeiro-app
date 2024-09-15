package com.yuri_kotlin_learning.models

import com.yuri_kotlin_learning.values.Birthday
import com.yuri_kotlin_learning.values.Email
import com.yuri_kotlin_learning.values.Username
import java.util.*

data class User(val name: Username, val email: Email, val dateOfBirth: Birthday) {
    val id: UUID = UUID.randomUUID()
}
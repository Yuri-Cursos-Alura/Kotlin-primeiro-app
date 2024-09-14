package com.aluGames.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Game {
    var info: Info = Info()

    override fun toString(): String {
        return """
            Info: 
            $info
        """.trimIndent()
    }
}

@Serializable
class Info {
    var title: String = ""
    var thumb: String = ""

    override fun toString(): String {
        return """
            Title: $title
            Thumb: $thumb
        """.trimIndent()
    }
}
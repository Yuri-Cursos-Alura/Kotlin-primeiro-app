package com.aluGames.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiGame(val info: ApiInfo);
@Serializable
data class ApiInfo(val title: String, val thumb: String);

class Game(val title: String, val thumb: String, val description: String) {
    override fun toString(): String {
        return "Game(title='$title', thumb='$thumb', description='$description')"
    }
}
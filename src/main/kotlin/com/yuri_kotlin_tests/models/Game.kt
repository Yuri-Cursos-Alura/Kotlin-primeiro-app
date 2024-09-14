package com.aluGames.com.yuri_kotlin_tests.models

import com.yuri_kotlin_tests.services.ApiGame

class Game(val title: String, val thumb: String, val description: String) {
    companion object {
        fun from(apiGame: ApiGame, description: String): Game {
            return Game(apiGame.info.title, apiGame.info.thumb, description)
        }
    }

    override fun toString(): String {
        return "Game(title='$title', thumb='$thumb', description='$description')"
    }
}
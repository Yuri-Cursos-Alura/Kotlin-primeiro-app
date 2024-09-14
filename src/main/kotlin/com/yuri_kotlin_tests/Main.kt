package com.aluGames.com.yuri_kotlin_tests

import com.aluGames.com.yuri_kotlin_tests.models.Game
import com.yuri_kotlin_tests.services.SharkApi
import kotlinx.serialization.json.Json
import java.util.Scanner

object Util {
    val reading = Scanner(System.`in`)
}

fun main() {
    println("Digite o id do jogo: ")
    val id = Util.reading.nextLine()

    if (id == null) {
        println("Id inválido")
        return
    }

    val intId = runCatching { id.toInt() }.getOrNull()

    if (intId == null) {
        println("Id precisa ser um número.")
        return
    }

    // id Lego = 612
    val gameApi = SharkApi()

    val gameFromApi = gameApi.getGameById(intId)

    if (gameFromApi == null) {
        println("Jogo não encontrado.")
        return
    }

    println(gameFromApi)

    println("Digite uma descrição: ")
    val description = Util.reading.nextLine()

    val game = Game.from(gameFromApi, description)

    println("Jogo final: $game")
}


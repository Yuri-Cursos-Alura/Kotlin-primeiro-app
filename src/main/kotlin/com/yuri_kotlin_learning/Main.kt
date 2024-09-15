package com.yuri_kotlin_learning

import com.yuri_kotlin_learning.values.Email
import com.yuri_kotlin_learning.models.Game
import com.yuri_kotlin_learning.models.User
import com.yuri_kotlin_learning.services.SharkApi
import com.yuri_kotlin_learning.values.Birthday
import com.yuri_kotlin_learning.values.Username
import java.time.LocalDate
import java.util.*

object Util {
    val reading = Scanner(System.`in`)
}

fun main() {
    val dateOfBirth = Birthday(LocalDate.of(2003, 12, 31))
    val email = Email("yurialmirp@gmail.com")
    val username = Username("Yuri Almir Pinto")

    val user = User(name = username, email = email, dateOfBirth = dateOfBirth)
    println(user)

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


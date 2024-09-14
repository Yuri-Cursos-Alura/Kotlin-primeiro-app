package com.aluGames

import com.aluGames.models.Game
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

object Util {
    val reading = Scanner(System.`in`)
    val json = Json {
        ignoreUnknownKeys = true
    }
}

fun main() {
    println("Digite o id do jogo: ")
    val id = Util.reading.nextLine()

    if (id == null) {
        println("Id inválido")
        return
    }

    val client = HttpClient.newHttpClient()
    // id Lego = 612
    val uri = URI.create("https://www.cheapshark.com/api/1.0/games?id=$id")
    val request = HttpRequest.newBuilder()
        .uri(uri)
        .build()

    val response = client.send(request, BodyHandlers.ofString())

    val text: String = response?.body() ?: return

    var game: Game? = null

    try {
        game = Util.json.decodeFromString<Game>(text)
    }
    catch (e: Exception) {
        when(e) {
            is SerializationException -> println("Valor retornado não era um jogo, provavelmente não existe: $text")
            is IllegalArgumentException -> println("Erro ao decodificar o json em um jogo: $text")
            else -> println("Erro desconhecido: $e")
        }

        return
    }

    println(game)
}


package minesweeper.util

import minesweeper.entitiy.Coordinates
import java.lang.Exception

object UserInputParser {

    fun readUserInput(): UserInput {
        var input: String? = null
        return try {
            input = readLine()

            input?.trim()
                ?.split(" ")
                ?.take(3)!!
                .let {
                    val x = it[1].toInt() - 1
                    val y = it[0].toInt() - 1
                    UserInput(Coordinates(x, y), it[2])
                }
        } catch (e: Exception) {
            throw IllegalArgumentException("Illegal input: $input")
        }
    }

    fun readInt() = readLine()?.toInt() ?: throw IllegalArgumentException("Not valid int!")
}

data class UserInput(val coordinates: Coordinates, val userActionStr: String)
package minesweeper

import minesweeper.actions.UserAction
import minesweeper.results.NotPermittedResult
import minesweeper.results.Result
import minesweeper.util.UserActionParser

fun main() {
    println("How many mines do you want on the field?")

    val initialMineCount = readLine()?.toInt()!!
    val mineField = MineField(9, 9, initialMineCount)

    var guessedX: Int
    var guessedY: Int
    var userAction: UserAction
    var prevResult: Result

    do {
        mineField.print()
        println("Set/unset mines marks or claim a cell as free:")
        readLine()
            ?.trim()
            ?.split(" ")
            ?.take(3)!!
            .also {
                guessedX = it[1].toInt() - 1
                guessedY = it[0].toInt() - 1
                userAction = UserActionParser.parse(it[2])
            }

        val tile = mineField.getTile(guessedX, guessedY)
        prevResult = if (tile != null) userAction.doAction(tile) else NotPermittedResult()
    } while (prevResult.shouldEndGame().not())

    println(prevResult.message)
}

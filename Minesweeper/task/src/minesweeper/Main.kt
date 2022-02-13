package minesweeper

import minesweeper.entitiy.MineField
import minesweeper.results.NotPermittedResult
import minesweeper.results.UserTurnResult
import minesweeper.strategy.DefaultMineFillingStrategy
import minesweeper.util.UserActionParser
import minesweeper.util.UserInputParser

fun main() {
    val mineField = MineField(9, 9, DefaultMineFillingStrategy())
    var prevUserTurnResult: UserTurnResult

    do {
        println(mineField.getAsString())
        println("Set/unset mines marks or claim a cell as free:")

        val userInput = UserInputParser.readUserInput()
        val userAction = UserActionParser.parse(userInput.userActionStr)
        val tile = mineField.getTile(userInput.coordinates)

        prevUserTurnResult = if (tile != null) {
            userAction.doAction(tile)
        } else {
            NotPermittedResult()
        }
        println(prevUserTurnResult.getMessageToPrint())
    } while (prevUserTurnResult.shouldEndGame().not())
}

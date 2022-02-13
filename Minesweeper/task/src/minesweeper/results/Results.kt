package minesweeper.results

import minesweeper.tile.TileView

interface UserTurnResult {
    fun shouldEndGame(): Boolean = false
    fun getMessageToPrint(): String = ""
}

abstract class GameOverResult(private val finalMineFieldToDisplay: String): UserTurnResult {
    protected abstract val detailedMessage: String
    override fun shouldEndGame() = true

    override fun getMessageToPrint() = "$detailedMessage${TileView.BREAK_LINE}$finalMineFieldToDisplay"
}

class WonResult(finalMineFieldToDisplay: String): GameOverResult(finalMineFieldToDisplay) {
    override val detailedMessage = "Congratulations! You found all the mines!"
}

class LooseResult(finalMineFieldToDisplay: String): GameOverResult(finalMineFieldToDisplay) {
    override val detailedMessage = "You stepped on a mine and failed!"
}

class NoOpResult: UserTurnResult

class NotPermittedResult : UserTurnResult
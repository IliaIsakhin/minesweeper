package minesweeper.actions

import minesweeper.results.UserTurnResult
import minesweeper.results.WonResult
import minesweeper.entitiy.tile.Tile

object MarkMineAction: UserAction {
    override fun getName() = "mine"

    override fun doAction(tile: Tile): UserTurnResult {
        val result = tile.mark()

        if (tile.mineField.containsUnmarkedMines().not()) return WonResult(tile.mineField.getAsString(finalForm = true))

        return result
    }
}
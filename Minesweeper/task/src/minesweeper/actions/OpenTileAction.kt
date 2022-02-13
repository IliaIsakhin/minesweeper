package minesweeper.actions

import minesweeper.results.UserTurnResult
import minesweeper.results.WonResult
import minesweeper.tile.Tile

class OpenTileAction: UserAction {

    override fun getName(): String = "Open"

    override fun doAction(tile: Tile): UserTurnResult {
        val filled = tile.mineField.fillMinesIfNeeded(tile.coordinates)
        val newTile = if (filled) tile.mineField.getTile(tile.coordinates)!! else tile
        val result = newTile.open()

        if (tile.mineField.containsOnlyUnopenedMines()) return WonResult(tile.mineField.getAsString(finalForm = true))

        return result
    }
}
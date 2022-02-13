package minesweeper.tile

import minesweeper.entitiy.Coordinates
import minesweeper.entitiy.MineField
import minesweeper.results.LooseResult
import minesweeper.results.UserTurnResult
import minesweeper.tile.TileView.*

class MineTile(coordinates: Coordinates, mineField: MineField, marked: Boolean = false): Tile(coordinates, mineField) {

    init {
        this.marked = marked
    }

    override val tileView = MINE_HIDDEN_TILE

    override fun open(): UserTurnResult {
        return LooseResult(mineField.getAsString(finalForm = true))
    }
}
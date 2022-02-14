package minesweeper.entitiy.tile

import minesweeper.entitiy.Coordinates
import minesweeper.entitiy.MineField
import minesweeper.results.NoOpResult
import minesweeper.results.NotPermittedResult
import minesweeper.results.UserTurnResult

class NumberedTile(
    coordinates: Coordinates,
    mineField: MineField,
    marked: Boolean = false,
    override val tileView: TileView
) : Tile(coordinates, mineField) {

    init {
        this.marked = marked
    }

    override fun display(): String {
        return if (opened.not()) {
            return if (marked) TileView.MARKED_TILE.symbol else TileView.UNOPENED_TILE.symbol
        } else tileView.symbol
    }

    override fun mark(): UserTurnResult {
        if (opened.not()) {
            marked = !marked
            return NoOpResult()
        }
        return NotPermittedResult()
    }
}
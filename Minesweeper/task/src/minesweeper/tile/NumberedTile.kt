package minesweeper.tile

import minesweeper.MineField
import minesweeper.results.NoOpResult
import minesweeper.results.NotPermittedResult
import minesweeper.results.Result

class NumberedTile(x: Int, y: Int, mineField: MineField, override val tileView: TileView) : Tile(x, y, mineField) {
    override fun display(): String {
        return if (opened.not()) {
            return if (marked) TileView.MARKED_TILE.symbol else TileView.UNOPENED_TILE.symbol
        } else tileView.symbol
    }

    override fun mark(): Result {
        if (opened.not()) {
            marked = !marked
            return NoOpResult()
        }
        return NotPermittedResult()
    }
}
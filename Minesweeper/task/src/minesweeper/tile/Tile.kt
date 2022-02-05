package minesweeper.tile

import minesweeper.MineField
import minesweeper.results.NotPermittedResult
import minesweeper.results.NoOpResult
import minesweeper.results.Result

abstract class Tile(x: Int, y: Int, var mineField: MineField): Cell(x, y) {

    abstract val tileView: TileView
    var marked: Boolean = false
    var opened: Boolean = false

    open fun open(): Result {
        if (!opened) {
            opened = true
            return NoOpResult()
        }

        return NotPermittedResult()
    }

    open fun display(): String {
        if (opened.not()) return TileView.UNOPENED_TILE.symbol
        return if (marked) TileView.MARKED_TILE.symbol else tileView.symbol
    }

    open fun mark(): Result {
        marked = !marked
        return NoOpResult()
    }
}

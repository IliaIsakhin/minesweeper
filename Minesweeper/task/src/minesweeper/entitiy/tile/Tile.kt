package minesweeper.entitiy.tile

import minesweeper.entitiy.Coordinates
import minesweeper.entitiy.MineField
import minesweeper.results.NotPermittedResult
import minesweeper.results.NoOpResult
import minesweeper.results.UserTurnResult

abstract class Tile(coordinates: Coordinates, var mineField: MineField): Cell(coordinates) {

    abstract val tileView: TileView
    var marked: Boolean = false
    var opened: Boolean = false

    open fun open(): UserTurnResult {
        if (!opened) {
            marked = false
            opened = true
            return NoOpResult()
        }

        return NotPermittedResult()
    }

    open fun display(): String {
        if (marked) return TileView.MARKED_TILE.symbol
        return if (opened.not()) return TileView.UNOPENED_TILE.symbol else tileView.symbol
    }

    fun displayTruly() = tileView.symbol

    open fun mark(): UserTurnResult {
        marked = !marked
        return NoOpResult()
    }
}

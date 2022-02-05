package minesweeper.tile

import minesweeper.MineField
import minesweeper.results.LooseResult
import minesweeper.results.Result
import minesweeper.results.WonResult
import minesweeper.tile.TileView.*

class MineTile(x: Int, y: Int, mineField: MineField): Tile(x, y, mineField) {

    override val tileView = MINE_HIDDEN_TILE

    override fun open(): Result {
        return LooseResult()
    }

    override fun mark(): Result {
        val result = super.mark()

        if (mineField.isMinesPresent().not()) return WonResult()

        return result
    }
}
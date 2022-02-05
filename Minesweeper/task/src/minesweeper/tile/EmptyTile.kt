package minesweeper.tile

import minesweeper.MineField
import minesweeper.results.NotPermittedResult
import minesweeper.results.NoOpResult
import minesweeper.results.Result

class EmptyTile(x: Int, y: Int, mineField: MineField) : Tile(x, y, mineField) {
    override val tileView: TileView = TileView.EMPTY_TILE

    override fun open(): Result {
        if (opened) return NotPermittedResult()
        opened = true

        val neighbourTiles = nearestCellsCoordinates
            .mapNotNull { (x, y) -> mineField.getTile(x, y) }
            .filter { it !is MineTile && it.opened.not() }

        if (neighbourTiles.isEmpty()) return NoOpResult()

        neighbourTiles.onEach { it.open() }

        return NoOpResult()
    }
}
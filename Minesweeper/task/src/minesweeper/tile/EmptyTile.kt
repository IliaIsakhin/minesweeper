package minesweeper.tile

import minesweeper.entitiy.Coordinates
import minesweeper.entitiy.MineField
import minesweeper.results.NotPermittedResult
import minesweeper.results.NoOpResult
import minesweeper.results.UserTurnResult

class EmptyTile(coordinates: Coordinates, mineField: MineField) : Tile(coordinates, mineField) {
    override val tileView: TileView = TileView.EMPTY_TILE

    override fun open(): UserTurnResult {
        if (opened) return NotPermittedResult()
        marked = false
        opened = true

        val neighbourTiles = nearestCellsCoordinates
            .mapNotNull(mineField::getTile)
            .filter { it !is MineTile && it.opened.not() }

        if (neighbourTiles.isEmpty()) return NoOpResult()

        neighbourTiles.onEach { it.open() }

        return NoOpResult()
    }
}
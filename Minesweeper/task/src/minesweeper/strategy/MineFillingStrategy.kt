package minesweeper.strategy

import minesweeper.entitiy.Coordinates
import minesweeper.entitiy.MineField
import minesweeper.entitiy.tile.MineTile
import minesweeper.entitiy.tile.NumberedTile
import minesweeper.entitiy.tile.TileView

interface MineFillingStrategy {

    fun isLazy() = false

    fun fill(mineField: MineField, startingCoordinate: Coordinates) {
        fillMines(mineField, startingCoordinate)
        fillTips(mineField)
    }

    fun fillMines(mineField: MineField, startingCoordinate: Coordinates)

    fun fillTips(mineField: MineField) {
        for (x in 0 until mineField.width) {
            for (y in 0 until mineField.width) {
                val coordinates = Coordinates(x, y)
                val currentTile = mineField.getTile(coordinates)!!

                if (currentTile is MineTile) continue

                val neighboursCount = currentTile.nearestCellsCoordinates
                    .map(mineField::getTile)
                    .count { it is MineTile }
                if (neighboursCount > 0) {
                    mineField.setTile(
                        NumberedTile(
                            coordinates,
                            mineField,
                            currentTile.marked,
                            TileView.resolveByNumber(neighboursCount)
                        )
                    )
                }
            }
        }
    }
}

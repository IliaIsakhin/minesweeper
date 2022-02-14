package minesweeper.strategy

import minesweeper.entitiy.Coordinates
import minesweeper.entitiy.MineField
import minesweeper.entitiy.tile.MineTile

class DebugMineFillingStrategy(private val mines: Set<Coordinates>): MineFillingStrategy {

    override fun fillMines(mineField: MineField, startingCoordinate: Coordinates) {
        mines.forEach {
            mineField.setTile(MineTile(it, mineField))
        }
    }
}
package minesweeper.strategy

import minesweeper.entitiy.Coordinates
import minesweeper.entitiy.MineField
import minesweeper.entitiy.tile.EmptyTile
import minesweeper.entitiy.tile.MineTile
import minesweeper.util.UserInputParser
import kotlin.random.Random

class DefaultMineFillingStrategy: MineFillingStrategy {
    private val initialMineCount: Int

    override fun isLazy() = true

    init {
        println("How many mines do you want on the field?")

        initialMineCount = UserInputParser.readInt()
    }

    override fun fillMines(mineField: MineField, startingCoordinate: Coordinates) {
        require(0 < initialMineCount && initialMineCount < mineField.width * mineField.height) {
            IllegalArgumentException("Cannot set mines to $initialMineCount")
        }

        var readyMines = 0
        do {
            var randomCoordinates: Coordinates
            do {
                randomCoordinates = Coordinates(Random.nextInt(mineField.width), Random.nextInt(mineField.height))
            } while (startingCoordinate == randomCoordinates)

            val selectedTile = mineField.getTile(randomCoordinates)

            if (selectedTile is EmptyTile) {
                mineField.setTile(MineTile(selectedTile.coordinates, mineField, selectedTile.marked))
                readyMines++
            }
        } while (readyMines != initialMineCount)
    }
}
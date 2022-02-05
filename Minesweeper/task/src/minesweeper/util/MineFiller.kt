package minesweeper.util

import minesweeper.MineField
import minesweeper.tile.EmptyTile
import minesweeper.tile.MineTile
import minesweeper.tile.NumberedTile
import minesweeper.tile.TileView
import kotlin.random.Random

fun MineField.fillMines(initialMineCount: Int) {
    var readyMines = 0
    do {
        val (randX, randY) = Pair(Random.nextInt(data.size), Random.nextInt(data.first().size))
        val current = data[randX][randY]

        if (current is EmptyTile) {
            data[randX][randY] = MineTile(randX, randY, this)
            readyMines++
        }
    } while (readyMines != initialMineCount)
}

fun MineField.fillTips() {
    for (x in data.indices) {
        for (y in data[0].indices) {
            val currentTile = data[x][y]

            if (currentTile is MineTile) continue

            val neighboursCount = currentTile.nearestCellsCoordinates
                .map { (x,y) -> getTile(x, y) }
                .count { it is MineTile }
            if (neighboursCount > 0) {
                data[x][y] = NumberedTile(x, y, this,TileView.resolveByNumber(neighboursCount))
            }
        }
    }
}

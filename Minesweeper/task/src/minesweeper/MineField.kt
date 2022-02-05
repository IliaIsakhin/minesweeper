package minesweeper

import minesweeper.tile.EmptyTile
import minesweeper.tile.MineTile
import minesweeper.tile.Tile
import minesweeper.util.fillMines
import minesweeper.util.fillTips

class MineField(width: Int, height: Int, initialMineCount: Int) {

    val data: Array<Array<Tile>> = run {
        require(width > 0)
        require(height > 0)

        Array(width) { x ->
            Array(height) { y ->
                EmptyTile(x, y, this)
            }
        }
    }

    init {
        fillData(initialMineCount)
    }

    fun isMinesPresent(): Boolean {
        return data.any() { arr ->
            arr.filterIsInstance<MineTile>().any() { it.marked.not() }
        }
    }

    fun getTile(x: Int, y: Int): Tile? = try {
        data[x][y]
    } catch (e: IndexOutOfBoundsException) {
        null
    }

    fun print() {
        println(Drawer.drawData(data))
    }

    private fun fillData(initialMineCount: Int) {
        fillMines(initialMineCount)
        fillTips()
    }
}

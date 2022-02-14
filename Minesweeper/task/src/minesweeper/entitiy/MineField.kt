package minesweeper.entitiy

import minesweeper.strategy.MineFillingStrategy
import minesweeper.entitiy.tile.EmptyTile
import minesweeper.entitiy.tile.MineTile
import minesweeper.entitiy.tile.Tile
import minesweeper.util.Drawer

class MineField(val width: Int, val height: Int, private val mineFillingStrategy: MineFillingStrategy) {

    private var initialized = false
    private val data: Array<Array<Tile>> = run {
        require(width > 0)
        require(height > 0)

        Array(width) { x ->
            Array(height) { y ->
                EmptyTile(Coordinates(x, y), this)
            }
        }
    }

    init {
        if (mineFillingStrategy.isLazy().not()) {
            fillMinesIfNeeded(Coordinates(0, 0))
        }
    }

    fun containsUnmarkedMines(): Boolean {
        val mineTiles = data.flatten().filterIsInstance<MineTile>()

        if (mineTiles.isEmpty()) return true

        return mineTiles.any() { it.marked.not() }
    }

    fun containsOnlyUnopenedMines(): Boolean {
        return data.flatten().filter { it.opened.not() }.all { it is MineTile }
    }

    fun getTile(coordinates: Coordinates): Tile? = try {
        data[coordinates.x][coordinates.y]
    } catch (e: IndexOutOfBoundsException) {
        null
    }

    fun setTile(tile: Tile) {
        data[tile.coordinates.x][tile.coordinates.y] = tile
    }

    fun getAsString(finalForm: Boolean = false) = Drawer.drawData(data, finalForm)

    fun fillMinesIfNeeded(excludeCoordinates: Coordinates): Boolean {
        if (initialized) return false

        mineFillingStrategy.fill(this, excludeCoordinates)
        initialized = true

        return true
    }
}

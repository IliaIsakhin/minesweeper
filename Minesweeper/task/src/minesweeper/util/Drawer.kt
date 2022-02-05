package minesweeper

import minesweeper.tile.Tile
import minesweeper.tile.TileView
import java.lang.StringBuilder

object Drawer {

    fun drawData(data: Array<Array<Tile>>): String {
        val result = StringBuilder()

        with(result) {
            append(" ")
            append(TileView.VERTICAL_BORDER)
            for (i in 1..data.size) { append(i) }
            append(TileView.VERTICAL_BORDER)
            append("\r\n")
            for (i in 1..data.size + 2) {
                if (i == 2)
                    append(TileView.VERTICAL_BORDER)
                else
                    append(TileView.HORISONTAL_BORDER)
            }
            append(TileView.VERTICAL_BORDER)
            append("\r\n")
            data.forEachIndexed() { idx, tiles ->
                append(idx+1)
                append(TileView.VERTICAL_BORDER)
                tiles.forEach {
                    append(it.display())
                }
                append(TileView.VERTICAL_BORDER)
                append("\r\n")
            }
            for (i in 1..data.size + 2) {
                if (i == 2)
                    append(TileView.VERTICAL_BORDER)
                else
                    append(TileView.HORISONTAL_BORDER)
            }
            append(TileView.VERTICAL_BORDER)
        }

        return result.toString()
    }
}

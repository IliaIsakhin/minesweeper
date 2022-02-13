package minesweeper.util

import minesweeper.tile.Tile
import minesweeper.tile.TileView
import java.lang.StringBuilder

object Drawer {

    fun drawData(data: Array<Array<Tile>>, finalForm: Boolean = false): String = with(StringBuilder()) {
        append(" ")
        append(TileView.VERTICAL_BORDER)
        for (i in 1..data.size) {
            append(i)
        }
        append(TileView.VERTICAL_BORDER)
        append(TileView.BREAK_LINE)
        for (i in 1..data.size + 2) {
            if (i == 2)
                append(TileView.VERTICAL_BORDER)
            else
                append(TileView.HORISONTAL_BORDER)
        }
        append(TileView.VERTICAL_BORDER)
        append(TileView.BREAK_LINE)
        data.forEachIndexed() { idx, tiles ->
            append(idx + 1)
            append(TileView.VERTICAL_BORDER)
            tiles.forEach {
                append(if (finalForm) it.displayTruly() else it.display())
            }
            append(TileView.VERTICAL_BORDER)
            append(TileView.BREAK_LINE)
        }
        for (i in 1..data.size + 2) {
            if (i == 2)
                append(TileView.VERTICAL_BORDER)
            else
                append(TileView.HORISONTAL_BORDER)
        }
        append(TileView.VERTICAL_BORDER)

        return@with toString()
    }
}

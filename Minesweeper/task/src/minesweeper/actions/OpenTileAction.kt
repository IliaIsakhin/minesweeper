package minesweeper.actions

import minesweeper.results.Result
import minesweeper.tile.Tile

class OpenTileAction: UserAction {

    override fun getName(): String = "Open"

    override fun doAction(tile: Tile): Result {
        return tile.open()
    }
}
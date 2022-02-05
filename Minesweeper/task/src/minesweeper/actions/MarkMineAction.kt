package minesweeper.actions

import minesweeper.results.Result
import minesweeper.tile.Tile

class MarkMineAction: UserAction {
    override fun getName() = "Mark"

    override fun doAction(tile: Tile): Result {
        return tile.mark()
    }
}
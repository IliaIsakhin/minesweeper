package minesweeper.actions

import minesweeper.results.Result
import minesweeper.tile.Tile

interface UserAction {

    fun getName(): String

    fun doAction(tile: Tile): Result
}


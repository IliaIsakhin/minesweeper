package minesweeper.actions

import minesweeper.results.UserTurnResult
import minesweeper.entitiy.tile.Tile

interface UserAction {

    fun getName(): String

    fun doAction(tile: Tile): UserTurnResult
}


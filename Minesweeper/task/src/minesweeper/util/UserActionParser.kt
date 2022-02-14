package minesweeper.util

import minesweeper.actions.MarkMineAction
import minesweeper.actions.OpenTileAction
import minesweeper.actions.UserAction

object UserActionParser {

    private val actions = listOf(MarkMineAction, OpenTileAction)

    fun getAvailableActionNames() = actions.joinToString(separator = ", ") { it.getName() }

    fun parse(str: String): UserAction {
        return actions.find { it.getName() == str }
            ?: throw IllegalArgumentException(
                """No action $str to run. Allowed actions: ${getAvailableActionNames()}"""
            )
    }
}
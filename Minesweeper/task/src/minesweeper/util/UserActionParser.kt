package minesweeper.util

import minesweeper.actions.MarkMineAction
import minesweeper.actions.OpenTileAction
import minesweeper.actions.UserAction

object UserActionParser {

    fun parse(str: String): UserAction {
        return when(str)  {
            "free" -> OpenTileAction()
            "mine" -> MarkMineAction()

            else -> throw IllegalArgumentException("""No action "$str" to run""")
        }
    }
}
package minesweeper.entitiy.tile

enum class TileView(val symbol: String) {
    EMPTY_TILE("/"),
    UNOPENED_TILE("."),
    MARKED_TILE("*"),
    MINE_HIDDEN_TILE("X"),

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),

    VERTICAL_BORDER("│"),
    HORISONTAL_BORDER("—"),
    BREAK_LINE("\r\n");

    override fun toString(): String = symbol

    companion object {
        fun resolveByNumber(num: Int): TileView {
            val strNum = num.toString()
            return values().find { strNum == it.symbol } ?: throw IllegalArgumentException()
        }
    }
}
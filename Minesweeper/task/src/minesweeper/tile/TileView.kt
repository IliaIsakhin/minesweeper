package minesweeper.tile

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
    NINE("9"),

    VERTICAL_BORDER("│"),
    HORISONTAL_BORDER("—");

    override fun toString(): String = symbol

    companion object {
        fun resolveByNumber(num: Int): TileView {
            val strNum = num.toString()
            return values().find { strNum == it.symbol } ?: throw IllegalArgumentException()
        }
    }
}
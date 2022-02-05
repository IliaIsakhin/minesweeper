package minesweeper.tile

abstract class Cell(val x: Int, val y: Int) {
    val nearestCellsCoordinates = listOf(
        Pair(x - 1, y - 1),
        Pair(x, y - 1),
        Pair(x + 1, y - 1),

        Pair(x - 1, y),
        Pair(x + 1, y),

        Pair(x - 1, y + 1),
        Pair(x, y + 1),
        Pair(x + 1, y + 1),
    )
}
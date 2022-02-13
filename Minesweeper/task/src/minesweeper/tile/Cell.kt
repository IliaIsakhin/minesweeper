package minesweeper.tile

import minesweeper.entitiy.Coordinates

abstract class Cell(val coordinates: Coordinates) {
    val nearestCellsCoordinates = listOf(
        Coordinates(coordinates.x - 1, coordinates.y - 1),
        Coordinates(coordinates.x,     coordinates.y - 1),
        Coordinates(coordinates.x + 1, coordinates.y - 1),

        Coordinates(coordinates.x - 1, coordinates.y),
        Coordinates(coordinates.x + 1, coordinates.y),

        Coordinates(coordinates.x - 1, coordinates.y + 1),
        Coordinates(coordinates.x,     coordinates.y + 1),
        Coordinates(coordinates.x + 1, coordinates.y + 1),
    )
}
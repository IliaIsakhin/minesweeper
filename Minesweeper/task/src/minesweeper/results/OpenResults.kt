package minesweeper.results

interface Result {
    fun shouldEndGame(): Boolean = false
    val message: String
}

interface GameOverResult: Result {
    override fun shouldEndGame() = true
}

class WonResult: GameOverResult {
    override val message: String = "Congratulations! You found all the mines!"
}

class LooseResult: GameOverResult {
    override val message: String = "You stepped on a mine and failed!"
}

class NoOpResult: Result {
    override val message: String = ""
}

class NotPermittedResult: Result {
    override val message: String = "Can`t do this action!"
}
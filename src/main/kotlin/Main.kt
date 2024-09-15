import game.Difficulty
import game.Game
import game.GameBuilder
import renderer.Renderer

fun main() {
    do {
        Renderer.displayWelcomeMessage()
        startGame()
    } while (InputManager.playAgain())
    Renderer.displayThankYouMessage()
}

fun startGame() {
    val difficulty = InputManager.chooseDifficulty()
    val currentGame = GameBuilder.createGame(difficulty)

    while (!currentGame.isGameOver()) {
        Renderer.displayHangmanDrawing(currentGame.attemptsLeft)
        Renderer.displayCurrentDifficulty(difficulty)

        val letter = InputManager.chooseLetter()
        if (currentGame.guess(letter)) {
            Renderer.displayCorrectGuess(letter)
        } else {
            Renderer.displayIncorrectGuess(letter)
        }

        Renderer.displayMaskedWord(currentGame.maskedWord)
    }
    Renderer.displayGameOver(currentGame.maskedWord == currentGame.currentWord, currentGame.currentWord)
}

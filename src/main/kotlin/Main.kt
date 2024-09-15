import game.Difficulty
import game.Game
import game.GameBuilder
import renderer.Renderer

fun main() {
    while (true) {
        Renderer.displayWelcomeMessage()
        val difficulty = InputManager.chooseDifficulty()
        val currentGame = GameBuilder.createGame(difficulty)

        startGame(currentGame, difficulty)
        if (!InputManager.playAgain()) {
            Renderer.displayThankYouMessage()
            break
        }
    }
}

fun startGame(currentGame: Game, difficulty: Difficulty) {
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

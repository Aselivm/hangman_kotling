import game.Game
import game.GameBuilder
import renderer.Renderer

fun main() {
    startGameLoop()
}

fun startGameLoop() {
    do {
        Renderer.displayWelcomeMessage()
        val difficulty = InputManager.chooseDifficulty()
        Renderer.displayCurrentDifficulty(difficulty)
        play(GameBuilder.createGame(difficulty))
    } while (InputManager.playAgain())
    Renderer.displayThankYouMessage()
}

fun play(currentGame: Game) {
    while (!currentGame.isGameOver()) {
        Renderer.displayHangmanDrawing(currentGame.attemptsLeft)

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

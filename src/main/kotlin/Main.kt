import manager.InputManager
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
        Renderer.displayHangmanDrawing(currentGame.attempts)

        val letter = InputManager.chooseLetter()
        if (currentGame.guess(letter)) {
            Renderer.displayCorrectGuess(letter)
        } else {
            Renderer.displayIncorrectGuess(letter)
        }
        Renderer.displayGuessedLetters(currentGame.guessedLettersArray)
        Renderer.displayMaskedWord(currentGame.maskedWordArray)
    }
    Renderer.displayGameOver(currentGame.isWin(), currentGame.word)
}

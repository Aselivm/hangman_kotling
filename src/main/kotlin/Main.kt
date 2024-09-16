import game.Game
import game.GameBuilder
import manager.InputManager
import renderer.Renderer

fun main() {
    GameProcess().start()
}

class GameProcess {
    fun start() {
        do {
            play(GameBuilder.createGame(InputManager.chooseDifficulty()))
        } while (InputManager.playAgain())
        Renderer.displayThankYouMessage()
    }

    private fun play(currentGame: Game) {
        Renderer.displayWelcomeMessage()
        Renderer.displayCurrentDifficulty(currentGame.difficulty)

        while (!currentGame.isGameOver()) {
            Renderer.displayHangmanDrawing(currentGame.remainingAttempts)
            processTurn(currentGame)
            Renderer.displayMaskedWord(currentGame.maskedWordArray)
        }

        Renderer.displayGameOver(currentGame.isWin(), currentGame.word)
    }

    private fun processTurn(currentGame: Game) {
        val letter = InputManager.chooseLetter()

        if (currentGame.guess(letter)) {
            Renderer.displayCorrectGuess(letter)
        } else {
            Renderer.displayIncorrectGuess(letter)
        }

        Renderer.displayGuessedLetters(currentGame.guessedLettersArray)
    }
}
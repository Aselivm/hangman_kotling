import game.Difficulty
import renderer.Renderer

class InputManager {
    companion object {
        fun chooseDifficulty(): Difficulty {
            Renderer.displayDifficultyOptions()
            while (true) {
                val difficulty = when (readlnOrNull()?.trim()) {
                    "1" -> Difficulty.EASY
                    "2" -> Difficulty.MEDIUM
                    "3" -> Difficulty.HARD
                    else -> {
                        Renderer.displayInvalidDifficultyChosen()
                        continue
                    }
                }
                Renderer.displayCurrentDifficulty(difficulty)
                return difficulty
            }
        }

        fun chooseLetter(): Char {
            Renderer.displayLetterPrompt()
            while (true) {
                val input = readlnOrNull()?.trim()
                if (input != null && input.length == 1 && isRussianLetter(input[0])) {
                    return input[0]
                } else {
                    Renderer.displayInvalidLetterInput()
                }
            }
        }

        fun playAgain(): Boolean {
            Renderer.displayPlayAgainPrompt()
            return readlnOrNull()?.trim()?.lowercase() == "да"
        }

        private fun isRussianLetter(char: Char): Boolean {
            return char in 'А'..'я'
        }
    }
}
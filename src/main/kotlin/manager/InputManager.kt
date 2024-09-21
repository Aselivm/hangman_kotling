package manager

import game.Difficulty
import renderer.Display

object InputManager {

    fun chooseDifficulty(): Difficulty {
        Display.showDifficultyOptions()
        while (true) {
            val difficulty = when (readlnOrNull()?.trim()) {
                "1" -> Difficulty.EASY
                "2" -> Difficulty.MEDIUM
                "3" -> Difficulty.HARD
                else -> {
                    Display.showInvalidDifficultyChosen()
                    continue
                }
            }
            Display.showCurrentDifficulty(difficulty)
            return difficulty
        }
    }

    fun chooseLetter(): Char {
        Display.showLetterPrompt()
        while (true) {
            val input = readlnOrNull()?.trim()
            if (input != null && input.length == 1 && isRussianLetter(input[0])) {
                return input[0]
            } else {
                Display.showInvalidLetterInput()
            }
        }
    }

    fun playAgain(): Boolean {
        Display.showPlayAgainPrompt() //todo сделать бесконечный цикл пока не введен валидный инпут
        return readlnOrNull()?.trim()?.lowercase() == "да"
    }

    private fun isRussianLetter(char: Char): Boolean {
        return char in 'А'..'я' || char == 'Ё' || char == 'ё'
    }

}
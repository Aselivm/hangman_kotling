package renderer

import game.Difficulty

object Renderer {
    fun displayWelcomeMessage() {
        println("Добро пожаловать в игру Хенгман!")
    }

    fun displayDifficultyOptions() {
        println("Выберите сложность (1 - Легкий, 2 - Средний, 3 - Сложный):")
    }

    fun displayCurrentDifficulty(difficulty: Difficulty) {
        println("Текущий уровень сложности: $difficulty")
    }

    fun displayInvalidDifficultyChosen() {
        println("Некорректный ввод. Пожалуйста, выберите 1, 2 или 3.")
    }

    fun displayLetterPrompt() {
        println("Введите букву:")
    }

    fun displayInvalidLetterInput() {
        println("Ошибка ввода. Пожалуйста, введите корректную русскую букву.")
    }

    fun displayCorrectGuess(letter: Char) {
        println("Правильный ввод: буква '$letter' присутствует в слове!")
    }

    fun displayIncorrectGuess(letter: Char) {
        println("Неправильный ввод: буква '$letter' отсутствует в слове.")
    }

    fun displayGameOver(isWin: Boolean, word: String) {
        val message = if (isWin) {
            "Поздравляем! Вы угадали слово: $word"
        } else {
            "Игра окончена. Загаданное слово было: $word"
        }
        println(message)
    }

    fun displayMaskedWord(maskedWordArray: CharArray) {
        println("Загаданное слово: $maskedWordArray")
    }

    fun displayPlayAgainPrompt() {
        println("Хотите сыграть снова? (да/нет)")
    }

    fun displayThankYouMessage() {
        println("Спасибо за игру!")
    }

    fun displayGuessedLetters(guessedLetters: Collection<Char>) {
        println("Guessed letters: ${guessedLetters.joinToString(", ")}")
    }

    fun displayHangmanDrawing(attemptsLeft: Int) {
        val hangman = when (attemptsLeft) {
            6 -> HangmanDrawings.HANGMAN_STAGE_6
            5 -> HangmanDrawings.HANGMAN_STAGE_5
            4 -> HangmanDrawings.HANGMAN_STAGE_4
            3 -> HangmanDrawings.HANGMAN_STAGE_3
            2 -> HangmanDrawings.HANGMAN_STAGE_2
            1 -> HangmanDrawings.HANGMAN_STAGE_1
            0 -> HangmanDrawings.HANGMAN_STAGE_0
            else -> throw IllegalArgumentException("Invalid number of attempts left: $attemptsLeft. Must be between 0 and 6.")
        }
        println(hangman)
    }
}

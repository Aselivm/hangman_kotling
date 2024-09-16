package game

class Game(
    val word: String,
    var remainingAttempts: Int,
    val difficulty: Difficulty
) {

    var maskedWordArray: CharArray
    var guessedLettersArray: MutableList<Char>

    init {
        maskedWordArray = hideWord(word)
        guessedLettersArray = mutableListOf()
    }

    fun guess(letter: Char): Boolean {
        if (!guessedLettersArray.contains(letter.lowercaseChar())) {
            guessedLettersArray.add(letter.lowercaseChar())
        }

        var isLetterFound = false

        word.forEachIndexed { index, char ->
            if (char.equals(letter, ignoreCase = true)) {
                maskedWordArray[index] = char
                isLetterFound = true
            }
        }

        if (!isLetterFound) {
            remainingAttempts--
        }

        return isLetterFound
    }

    fun isGameOver(): Boolean {
        return remainingAttempts <= 0 || maskedWordArray.joinToString("") == word
    }

    fun isWin(): Boolean {
        return maskedWordArray.joinToString("") == word
    }

    private fun hideWord(word: String) : CharArray {
        return word.map { '_' }.toCharArray()
    }
}
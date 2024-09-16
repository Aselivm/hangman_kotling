package game

class Game(
    val word: String,
    var attempts: Int
) {

    var maskedWordArray: CharArray = hideWord(word)
    var guessedLettersArray: MutableList<Char> = mutableListOf()

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
            attempts--
        }

        return isLetterFound
    }

    fun isGameOver(): Boolean {
        return attempts <= 0 || maskedWordArray.joinToString("") == word
    }

    fun isWin(): Boolean {
        return maskedWordArray.joinToString("") == word
    }

    private fun hideWord(word: String) : CharArray {
        return word.map { '_' }.toCharArray()
    }
}
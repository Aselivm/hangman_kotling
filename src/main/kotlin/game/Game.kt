package game

class Game(private val word: String, private var attempts: Int) {

    private var maskedWordArray: CharArray = word.map { '_' }.toCharArray()
    private var guessedLettersArray: MutableList<Char> = mutableListOf()

    val currentWord: String
        get() = word //todo no getters in kotlin

    val maskedWord: String
        get() = maskedWordArray.joinToString("")

    val attemptsLeft: Int
        get() = attempts

    val guessedLetters: String
        get() = guessedLettersArray.joinToString(", ") //todo: never used

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
}
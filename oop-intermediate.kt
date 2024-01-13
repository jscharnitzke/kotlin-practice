
data class Question<AnswerType>(
    val questionText: String,
    val answer: AnswerType,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    // companion class (`companion`): properties can be accessed directly
    companion object StudentProgress {
        // singleton class (`object`): can't be instantiated only accessed directly
        var total: Int = 10
        var answered: Int = 3
	}
}

// extend a class with a property; can customize getters and setters
val Quiz.StudentProgress.progressText: String
	get() = "$answered of $total answered."

// extend a class with a method
fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}

fun main() {
    println(Quiz.printProgressBar())
}

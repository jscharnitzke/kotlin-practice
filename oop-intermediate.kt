data class Question<AnswerType>(
        val questionText: String,
        val answer: AnswerType,
        val difficulty: Difficulty
)

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

interface ProgressPrintable {
    val progressText: String

    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    override val progressText: String
        get() = "$answered of $total answered."
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 =
            Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    // companion class (`companion`): properties can be accessed directly
    companion object StudentProgress {
        // singleton class (`object`): can't be instantiated only accessed directly
        var total: Int = 10
        var answered: Int = 3
    }

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
}

// extend a class with a property; can customize getters and setters
// removed to demonstrate interface overrides
// val Quiz.StudentProgress.progressText: String
// 	get() = "$answered of $total answered."

// extend a class with a method
// removed to demonstrate interface overrides
// fun Quiz.StudentProgress.printProgressBar() {
//     repeat(Quiz.answered) { print("▓") }
//     repeat(Quiz.total - Quiz.answered) { print("▒") }
//     println()
//     println(Quiz.progressText)
// }

fun main() {
    Quiz().printProgressBar()
}

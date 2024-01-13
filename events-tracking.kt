enum class DayPart {
  MORNING,
  AFTERNOON,
  EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: DayPart,
    val durationInMinutes: Int
)

fun main() {
  println(
      Event(
          "Study Kotlin",
          "Commit to studying Kotlin at least 15 minutes per day.",
          DayPart.EVENING,
          15
      )
  )
}

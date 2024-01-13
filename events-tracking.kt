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
  val events =
      mutableListOf(
          Event(
              title = "Wake up",
              description = "Time to get up",
              daypart = DayPart.MORNING,
              durationInMinutes = 0
          ),
          Event(title = "Eat breakfast", daypart = DayPart.MORNING, durationInMinutes = 15),
          Event(title = "Learn about Kotlin", daypart = DayPart.AFTERNOON, durationInMinutes = 30),
          Event(title = "Practice Compose", daypart = DayPart.AFTERNOON, durationInMinutes = 60),
          Event(
              title = "Watch latest DevBytes video",
              daypart = DayPart.AFTERNOON,
              durationInMinutes = 10
          ),
          Event(
              title = "Check out latest Android Jetpack library",
              daypart = DayPart.EVENING,
              durationInMinutes = 45
          ),
      )
}

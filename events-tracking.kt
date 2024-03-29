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

val Event.durationOfEvent: String
  get() {
    return if (durationInMinutes < 60) "short" else "long"
  }

class User(val events: MutableList<Event>) {
  fun printLastEvent() {
    println("Last event of the day: ${events.last().title}")
  }

  fun summarizeDayPartEvents() {
    val groupedEvents = events.groupBy { it.daypart }

    groupedEvents.forEach { (daypart, events) -> println("$daypart: ${events.size} events") }
  }

  fun summarizeShortEvents() {
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")
  }
}

fun main() {
  val user =
      User(
          mutableListOf(
              Event(
                  title = "Wake up",
                  description = "Time to get up",
                  daypart = DayPart.MORNING,
                  durationInMinutes = 0
              ),
              Event(title = "Eat breakfast", daypart = DayPart.MORNING, durationInMinutes = 15),
              Event(
                  title = "Learn about Kotlin",
                  daypart = DayPart.AFTERNOON,
                  durationInMinutes = 30
              ),
              Event(
                  title = "Practice Compose",
                  daypart = DayPart.AFTERNOON,
                  durationInMinutes = 60
              ),
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
      )

  println("Duration of first event of the day: ${user.events[0].durationOfEvent}")
}

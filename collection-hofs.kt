class Cookie(val name: String, val softBaked: Boolean, val hasFilling: Boolean, val price: Double)

val cookies =
    listOf(
        Cookie("Chocolate Chip", false, false, 1.69),
        Cookie("Banana Walnut", true, false, 1.49),
        Cookie("Vanilla Creme", false, true, 1.59),
        Cookie("Chocolate Peanut Butter", false, true, 1.49),
        Cookie("Snickerdoodle", true, false, 1.39),
        Cookie("Blueberry Tart", true, true, 1.79),
        Cookie("Sugar and Sprinkles", false, false, 1.39)
    )

fun main() {
  // cookies.forEach { println("Menu item: ${it.name}") }

  // val fullMenu = cookies.map { "${it.name} - $${it.price}" }
  // fullMenu.forEach { println(it) }

  // val softBakedMenu = cookies.filter { it.softBaked }

  // println("Soft cookies:")
  // softBakedMenu.forEach { println("${it.name} - $${it.price}") }

  // val groupedMenu = cookies.groupBy { it.softBaked }
  // val softBakedMenu = groupedMenu[true] ?: emptyList()
  // val crunchyMenu = groupedMenu[false] ?: emptyList()

  // println("Soft cookies:")
  // softBakedMenu.forEach { println("${it.name} - $${it.price}") }
  // println()
  // println("Crunchy cookies:")
  // crunchyMenu.forEach { println("${it.name} - $${it.price}") }

  // val totalPrice = cookies.fold(0.0) { total, cookie -> total + cookie.price }
  // println("Total price: $$totalPrice")

  val alphabeticalMenu = cookies.sortedBy { it.name }
  println("Alphabetical menu:")
  alphabeticalMenu.forEach { println(it.name) }
}

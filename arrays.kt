fun main() {
  val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
  val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")

  val solarSystem = rockPlanets + gasPlanets

  solarSystem[3] = "Little Earth"

  println(solarSystem[0])
  println(solarSystem[1])
  println(solarSystem[2])
  println(solarSystem[3])
  println(solarSystem[4])
  println(solarSystem[5])
  println(solarSystem[6])
  println(solarSystem[7])
}

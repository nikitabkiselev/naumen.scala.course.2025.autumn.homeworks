import java.lang.Math

object Task4 {
  val balls: Map[String, (Int, Double)] = Map(
    "Aluminum" -> (3, 2.6889),
    "Tungsten" -> (2, 19.35),
    "Graphite" -> (12, 2.1),
    "Iron" -> (3, 7.874),
    "Gold" -> (2, 19.32),
    "Potassium" -> (14, 0.862),
    "Calcium" -> (8, 1.55),
    "Cobalt" -> (4, 8.90),
    "Lithium" -> (12, 0.534),
    "Magnesium" -> (10, 1.738),
    "Copper" -> (3, 8.96),
    "Sodium" -> (5, 0.971),
    "Nickel" -> (2, 8.91),
    "Tin" -> (1, 7.29),
    "Platinum" -> (1, 21.45),
    "Plutonium" -> (3, 19.25),
    "Lead" -> (2, 11.336),
    "Titanium" -> (2, 10.50),
    "Silver" -> (4, 4.505),
    "Uranium" -> (2, 19.04),
    "Chrome" -> (3, 7.18),
    "Cesium" -> (7, 1.873),
    "Zirconium" -> (3, 6.45)
  )

  def calculateMass(radius: Int, density: Double): Double = {
    (4.0 / 3.0) * Math.PI * Math.pow(radius, 3) * density
  }

  def sortByHeavyweight(ballsArray: Map[String, (Int, Double)]): Seq[String] = {
    ballsArray.toList.sortBy { case (_, (radius, density)) =>
      // Сортируем по отрицательному значению массы, чтобы получить убывающий порядок
      -calculateMass(radius, density)
    }.map(_._1)
  }
}

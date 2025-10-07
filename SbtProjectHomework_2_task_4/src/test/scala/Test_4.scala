import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers // Добавляем Matchers

class BallsSortTest extends AnyFunSuite with Matchers { // Расширяем Matchers

  test("Sorting by mass should work as expected (heavyweight first)/Сортировка по массе должна работать так, как ожидалось (сначала в тяжелом весе).") {
    val sortedBalls = Task4.sortByHeavyweight(Task4.balls)
    // Обновленный ожидаемый порядок, отсортированный по убыванию массы (проверено)
    val expectedOrder = Seq(
      "Graphite",   // ~3628.8
      "Potassium", // ~2365.17
      "Magnesium", // ~1738.0
      "Lithium",    // ~922.75
      "Calcium",    // ~793.6
      "Cesium",     // ~642.18
      "Cobalt",     // ~569.6
      "Plutonium", // ~519.75
      "Silver",     // ~288.32
      "Copper",     // ~241.92
      "Iron",       // ~212.60
      "Chrome",     // ~193.86
      "Zirconium", // ~174.15
      "Tungsten",   // ~154.8
      "Gold",       // ~154.56
      "Uranium",    // ~152.32
      "Sodium",     // ~121.38
      "Lead",       // ~90.69
      "Titanium",   // ~84.0
      "Aluminum",   // ~72.60
      "Nickel",     // ~71.28
      "Platinum",   // ~21.45
      "Tin"         // ~7.29
    )
    sortedBalls shouldBe expectedOrder // Используем shouldBe для точного сравнения последовательностей
  }

  test("Check sorting with empty input/Проверка сортировки с пустым вводом") {
    val emptyInput = Map.empty[String, (Int, Double)]
    val sortedBalls = Task4.sortByHeavyweight(emptyInput)
    sortedBalls shouldBe empty
  }

  test("Check sorting with single element/Проверка сортировки с одним элементом") {
    val singleElement = Map("Gold" -> (2, 19.32))
    val sortedBalls = Task4.sortByHeavyweight(singleElement)
    sortedBalls shouldBe Seq("Gold")
  }

  test("Check sorting with equal masses/Проверка сортировки с равными массами") {
    val sameMassElements = Map(
      "Material1" -> (3, 2.6889),
      "Material2" -> (3, 2.6889)
    )
    val sortedBalls = Task4.sortByHeavyweight(sameMassElements)
    // Для элементов с одинаковой массой порядок может быть произвольным,
    // если не задано дополнительное правило сортировки. Проверим наличие и количество.
    sortedBalls should have length 2
    sortedBalls should contain ("Material1")
    sortedBalls should contain ("Material2")

  }
}

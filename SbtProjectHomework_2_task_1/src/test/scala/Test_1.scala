import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

// Класс SumOfDivTest теперь является топ-уровневым
class SumOfDivTest extends AnyFunSuite with Matchers {

  // Тест для диапазона, где есть числа, делящиеся на 3 и 5
  test("sumOfDivBy3Or5 should return correct sum for a typical range/sumOfDivBy3Or5 должен возвращать правильную сумму для типичного диапазона") {
    Task_1.sumOfDivBy3Or5(1, 15) shouldBe 60L
  }

  // Тест для диапазона, начинающегося с нуля
  test("sumOfDivBy3Or5 should handle range starting from zero/sumOfDivBy3Or5 должен обрабатывать диапазон, начинающийся с нуля") {
    Task_1.sumOfDivBy3Or5(0, 10) shouldBe 33L
  }

  // Тест для диапазона, где нет чисел, делящихся на 3 или 5 (корректный)
  test("sumOfDivBy3Or5 should return 0 when no numbers are divisible by 3 or 5/sumOfDivBy3Or5 должен возвращать 0, если ни одно число не делится на 3 или 5") {
    Task_1.sumOfDivBy3Or5(1, 2) shouldBe 0L
    Task_1.sumOfDivBy3Or5(4, 4) shouldBe 0L
  }

  // Корректный тест для диапазона 1-11 (который содержит делители)
  test("sumOfDivBy3Or5 should return correct sum for range 1-11/sumOfDivBy3Or5 должен возвращать правильную сумму для диапазона 1-11") {
    Task_1.sumOfDivBy3Or5(1, 11) shouldBe 33L
  }

  // Тест для диапазона с одним элементом
  test("sumOfDivBy3Or5 should handle single element range correctly/sumOfDivBy3Or5 должен корректно обрабатывать диапазон отдельных элементов") {
    Task_1.sumOfDivBy3Or5(3, 3) shouldBe 3L
    Task_1.sumOfDivBy3Or5(5, 5) shouldBe 5L
    Task_1.sumOfDivBy3Or5(7, 7) shouldBe 0L
  }

  // Тест для некорректного диапазона (iFrom > iTo)
  test("sumOfDivBy3Or5 should return 0 for an invalid range where iFrom > iTo/sumOfDivBy3Or5 должен возвращать 0 для недопустимого диапазона, где iFrom > iTo") {
    Task_1.sumOfDivBy3Or5(10, 1) shouldBe 0L
    Task_1.sumOfDivBy3Or5(5, 3) shouldBe 0L
  }

  // Тест для отрицательных чисел
  test("sumOfDivBy3Or5 should handle negative numbers correctly/sumOfDivBy3Or5 должен корректно обрабатывать отрицательные числа") {
    Task_1.sumOfDivBy3Or5(-10, 10) shouldBe 0L
    Task_1.sumOfDivBy3Or5(-15, -1) shouldBe -60L
  }

  // Тест, проверяющий, что сумма не переполняет Int
  test("sumOfDivBy3Or5 should handle large ranges without Int overflow/sumOfDivBy3Or5 должен обрабатывать большие диапазоны без переполнения Int") {
    Task_1.sumOfDivBy3Or5(1, 1000) shouldBe 234168L
    // Добавим более крупный тест для демонстрации Long, если сумма превышает Int.MaxValue
    // Если это значение превышает Int.MaxValue, удостоверьтесь, что ваша функция возвращает Long
    Task_1.sumOfDivBy3Or5(1, 100000) shouldBe 2333416668L
  }
}

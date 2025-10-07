import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PrimeFactorizationSpec extends AnyFunSuite with Matchers {

  // Тест для примера из задания: 80 = 2*2*2*2*5
  test("primeFactor should return Seq(2, 5) for 80/primeFactor должен возвращать значение Seq(2, 5) для 80") {
    PrimeFactorization.primeFactor(80) shouldBe Seq(2, 5)
  }

  // Тест для примера из задания: 98 = 2*7*7
  test("primeFactor should return Seq(2, 7) for 98/primeFactor должен возвращать значение Seq(2, 7) для 98") {
    PrimeFactorization.primeFactor(98) shouldBe Seq(2, 7)
  }

  // Тест для простого числа
  test("primeFactor should return Seq(primeNumber) for a prime number/primeFactor должен возвращать Seq(primeNumber) для простого числа") {
    PrimeFactorization.primeFactor(7) shouldBe Seq(7)
    PrimeFactorization.primeFactor(13) shouldBe Seq(13)
    PrimeFactorization.primeFactor(29) shouldBe Seq(29)
  }

  // Тест для числа 1
  test("primeFactor should return an empty Seq for 1/primeFactor должен возвращать пустое значение Seq для 1") {
    PrimeFactorization.primeFactor(1) shouldBe Seq.empty[Int]
  }

  // Тест для 0
  test("primeFactor should return an empty Seq for 0/primeFactor должен возвращать пустое значение Seq для 0") {
    PrimeFactorization.primeFactor(0) shouldBe Seq.empty[Int]
  }

  // Тест для отрицательного числа
  test("primeFactor should return an empty Seq for negative numbers/primeFactor должен возвращать пустой Seq для отрицательных чисел") {
    PrimeFactorization.primeFactor(-10) shouldBe Seq.empty[Int]
    PrimeFactorization.primeFactor(-1) shouldBe Seq.empty[Int]
  }

  // Тест для числа, состоящего из одного простого множителя (возведенного в степень)
  test("primeFactor should return Seq(prime) for powers of a prime number/primeFactor должен возвращать значение Seq(простое число) для степеней простого числа") {
    PrimeFactorization.primeFactor(8) shouldBe Seq(2)
    PrimeFactorization.primeFactor(27) shouldBe Seq(3)
    PrimeFactorization.primeFactor(16) shouldBe Seq(2)
  }

  // Тест для числа с несколькими различными простыми множителями
  test("primeFactor should handle multiple distinct prime factors/primeFactor должен обрабатывать несколько различных простых множителей") {
    PrimeFactorization.primeFactor(12) shouldBe Seq(2, 3) // 12 = 2*2*3
    PrimeFactorization.primeFactor(30) shouldBe Seq(2, 3, 5) // 30 = 2*3*5
    PrimeFactorization.primeFactor(42) shouldBe Seq(2, 3, 7) // 42 = 2*3*7
    PrimeFactorization.primeFactor(100) shouldBe Seq(2, 5) // 100 = 2*2*5*5
  }

  // Тест для большого числа
  test("primeFactor should handle a larger number/primeFactor должен обрабатывать большее число") {
    // 13195 = 5 * 7 * 13 * 29
    PrimeFactorization.primeFactor(13195) shouldBe Seq(5, 7, 13, 29)
  }
}





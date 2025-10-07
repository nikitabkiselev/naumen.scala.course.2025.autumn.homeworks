import scala.collection.immutable.Set

object PrimeFactorization {

  def primeFactor(number: Int): Seq[Int] = {
    // Обрабатываем случаи, когда число меньше или равно 1
    if (number <= 1) {
      Seq.empty[Int] // Простые множители для чисел <=1 не определены или пусты
    } else {
      // Используем вспомогательный метод для рекурсивного разложения
      findFactors(number, 2, Set.empty[Int]).toSeq.sorted // Преобразуем Set в Seq и сортируем
    }
  }
 private def findFactors(n: Int, divisor: Int, acc: Set[Int]): Set[Int] = {
    if (n <= 1) {
      // Базовый случай: число разложено полностью
      acc
    } else if (divisor * divisor > n) {
      // Оптимизация: если квадрат делителя больше числа,
      // значит, оставшееся число 'n' само является простым множителем
      acc + n
    } else if (n % divisor == 0) {
      // Если текущий делитель является множителем
      // Добавляем его в аккумулятор и продолжаем разложение числа,
      // деленного на этот делитель, используя тот же делитель (для обработки степеней)
      findFactors(n / divisor, divisor, acc + divisor)
    } else {
      // Если текущий делитель не является множителем, пробуем следующий
      findFactors(n, divisor + 1, acc)
    }
  }
}

import java.lang.Math

// Определение класса двумерного вектора
case class Vector2D(x: Double, y: Double)

// Вспомогательные функции для работы с векторами
object VectorUtils {
  def abs(vec: Vector2D): Double =
    Math.sqrt(vec.x * vec.x + vec.y * vec.y)
  def scalar(vec0: Vector2D, vec1: Vector2D): Double =
    vec0.x * vec1.x + vec0.y * vec1.y
  def cosBetween(vec0: Vector2D, vec1: Vector2D): Double = {
    val abs0 = abs(vec0)
    val abs1 = abs(vec1)
    if (abs0 == 0.0 || abs1 == 0.0) {
      Double.NaN
    } else {
      scalar(vec0, vec1) / (abs0 * abs1)
    }
  }
  def sumByFunc(leftVec0: Vector2D,
                leftVec1: Vector2D,
                func: (Vector2D, Vector2D) => Double,
                rightVec0: Vector2D,
                rightVec1: Vector2D): Double = {
    func(leftVec0, leftVec1) + func(rightVec0, rightVec1)
  }

  // Функция для вычисления суммы скалярных произведений
  def sumScalars(leftVec0: Vector2D,
                 leftVec1: Vector2D,
                 rightVec0: Vector2D,
                 rightVec1: Vector2D): Double = {
    sumByFunc(leftVec0, leftVec1, scalar, rightVec0, rightVec1)
  }

  // Функция для вычисления суммы косинусов углов между векторами
  def sumCosines(leftVec0: Vector2D,
                 leftVec1: Vector2D,
                 rightVec0: Vector2D,
                 rightVec1: Vector2D): Double = {
    sumByFunc(leftVec0, leftVec1, cosBetween, rightVec0, rightVec1)
  }
}

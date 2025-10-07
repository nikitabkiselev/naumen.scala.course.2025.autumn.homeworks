import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class VectorUtilsSpec extends AnyFunSuite with Matchers {

  // --- Тесты для sumScalars ---

  test("sumScalars должны вычислять сумму скалярных произведений для ортогональных векторов") {
    val v1 = Vector2D(1.0, 0.0)
    val v2 = Vector2D(0.0, 1.0)
    val v3 = Vector2D(2.0, 0.0)
    val v4 = Vector2D(0.0, 3.0)
    VectorUtils.sumScalars(v1, v2, v3, v4) shouldBe 0.0
  }

  test("sumScalars должны вычислять сумму скалярных произведений для параллельных векторов") {
    val v1 = Vector2D(2.0, 3.0)
    val v2 = Vector2D(4.0, 6.0)
    val v3 = Vector2D(1.0, 1.0)
    val v4 = Vector2D(3.0, 3.0)
    VectorUtils.sumScalars(v1, v2, v3, v4) shouldBe 32.0
  }

  test("sumScalars должны вычислять сумму скалярных произведений для произвольных векторов") {
    val v1 = Vector2D(1.0, 2.0)
    val v2 = Vector2D(3.0, 4.0)
    val v3 = Vector2D(-1.0, 0.5)
    val v4 = Vector2D(2.0, -3.0)
    VectorUtils.sumScalars(v1, v2, v3, v4) shouldBe 7.5
  }

  test("sumScalars должны корректно обрабатывать нулевые векторы") {
    val v1 = Vector2D(1.0, 2.0)
    val v2 = Vector2D(0.0, 0.0)
    val v3 = Vector2D(3.0, 4.0)
    val v4 = Vector2D(5.0, 6.0)
    VectorUtils.sumScalars(v1, v2, v3, v4) shouldBe 39.0
  }

  // --- Тесты для sumCosines ---

  val TOLERANCE = 0.000000001

  test("sumCosines должны вычислять сумму косинусов для параллельных векторов") {
    val v1 = Vector2D(1.0, 1.0)
    val v2 = Vector2D(2.0, 2.0)
    val v3 = Vector2D(1.0, 0.0)
    val v4 = Vector2D(3.0, 0.0)
    VectorUtils.sumCosines(v1, v2, v3, v4) shouldBe (2.0 +- TOLERANCE)
  }

  test("sumCosines должны вычислять сумму косинусов для антипараллельных векторов") {
    val v1 = Vector2D(1.0, 1.0)
    val v2 = Vector2D(-2.0, -2.0)
    val v3 = Vector2D(1.0, 0.0)
    val v4 = Vector2D(-3.0, 0.0)
    VectorUtils.sumCosines(v1, v2, v3, v4) shouldBe (-2.0 +- TOLERANCE)
  }

  test("sumCosines должны вычислять сумму косинусов для ортогональных векторов") {
    val v1 = Vector2D(1.0, 0.0)
    val v2 = Vector2D(0.0, 1.0)
    val v3 = Vector2D(2.0, 3.0)
    val v4 = Vector2D(-3.0, 2.0)
    VectorUtils.sumCosines(v1, v2, v3, v4) shouldBe (0.0 +- TOLERANCE)
  }

  test("sumCosines должны вычислять сумму косинусов для произвольных векторов") {
    val v1 = Vector2D(1.0, 1.0)
    val v2 = Vector2D(1.0, 0.0)
    val v3 = Vector2D(0.0, 1.0)
    val v4 = Vector2D(1.0, -1.0)

    VectorUtils.sumCosines(v1, v2, v3, v4) shouldBe (0.0 +- TOLERANCE)
  }

  test("sumCosines должны возвращать NaN при наличии нулевого вектора") {
    val v1 = Vector2D(1.0, 1.0)
    val v2 = Vector2D(2.0, 2.0)
    val zeroVec = Vector2D(0.0, 0.0)
    val v3 = Vector2D(3.0, 4.0)

        VectorUtils.sumCosines(v1, zeroVec, v3, v2).isNaN shouldBe true
        VectorUtils.sumCosines(zeroVec, v1, v3, v2).isNaN shouldBe true
  }
}

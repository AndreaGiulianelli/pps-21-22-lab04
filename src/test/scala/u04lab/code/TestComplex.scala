package scala.u04lab.code


import org.junit.Assert.assertEquals
import org.junit.Test
import u04lab.code.Complex

class TestComplex {
  private val c1: Complex = Complex(1, 2)
  private val c2: Complex = Complex(3, 4)

  @Test
  def testComplexSum(): Unit = assertEquals(Complex(4, 6), c1 + c2)
  @Test
  def testComplexProd(): Unit = assertEquals(Complex(-5, 10), c1 * c2)
}

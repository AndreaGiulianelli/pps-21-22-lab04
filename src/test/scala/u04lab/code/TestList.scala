package scala.u04lab.code

import org.junit.Assert.assertEquals
import org.junit.Test
import u04lab.code.List
import u04lab.code.List.*

class TestList {
  @Test
  def testFactory(): Unit =
    assertEquals(Cons(1, Cons(2, Cons(3, Nil()))), List(1, 2, 3))
}

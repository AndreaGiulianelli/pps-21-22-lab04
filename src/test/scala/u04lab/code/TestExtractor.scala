package scala.u04lab.code

import org.junit.Test
import u04lab.code.{Course, List, SameTeacher}
import u04lab.code.List.*
import org.junit.Assert.{assertEquals, assertTrue}

class TestExtractor {
  val courseListSameTeacher: List[Course] = Cons(Course("OOP", "Viroli"), Cons(Course("PPS", "Viroli"), Nil()))
  val courseListNoSameTeacher: List[Course] = Cons(Course("OOP", "Viroli"), Cons(Course("PCD", "Ricci"), Nil()))

  @Test
  def testExtractor(): Unit =
    val SameTeacher(t) = courseListSameTeacher
    assertEquals("Viroli", t)

  @Test
  def testExtractorNone(): Unit = courseListNoSameTeacher match
    case SameTeacher(t) => assertTrue(false)
    case _ => assertTrue(true)

}

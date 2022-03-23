package scala.u04lab.polyglot

import org.junit.Test
import org.junit.Assert.{assertEquals, assertNotEquals, assertNotNull, assertTrue}
import u04lab.polyglot.a01b.LogicsImpl
import u04lab.code.List
import u04lab.code.List.*
import u04lab.polyglot.Pair
import java.util.Optional
import u04lab.code.Option

import scala.util.Random

class TestLogics {
  private val size = 4
  private val mines = 2
  private val logics = LogicsImpl(size, mines)
  private val rnd = Random()

  @Test
  def testInit: Unit =
    assertTrue(List.length(logics.getMines) == mines)

  @Test
  def testHit(): Unit =
    val point = selectPointNotAMine()
    assertNotEquals(logics.hit(point.getX, point.getY), Optional.empty())

  @Test
  def testHitMine(): Unit =
    val point = Option.orElse(List.find(logics.getMines)(x => true), Pair(0, 0))
    assertEquals(logics.hit(point.getX, point.getY), Optional.empty())

  @Test
  def testWon(): Unit =
    for i <- 1 to size * size - mines do
      val point = selectPointNotAMine()
      logics.hit(point.getX, point.getY)
    assertTrue(logics.won)

  private def selectPointNotAMine(): Pair[Int, Int] = (rnd.nextInt(size), rnd.nextInt(size)) match
    case (x, y) if List.contains(logics.getMines, Pair(x, y)) => selectPointNotAMine()
    case (x, y) => Pair(x, y)
}

package u04lab.polyglot.a01b

import u04lab.polyglot.*
import u04lab.code.Option.*
import u04lab.code.List
import u04lab.code.Stream
import u04lab.code.List.*
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:
  private var minesList: List[Pair[Int, Int]] = Nil()
  private var selected: List[Pair[Int, Int]] = Nil()
  private val rnd = Random()

  placeMines(mines)
  println(minesList)

  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    if !List.contains(minesList, Pair(x, y)) then
      {selected = Cons(Pair(x, y), selected); OptionToOptional(Some(neighbours(x, y)))}
    else OptionToOptional(None())

  def won = mines + List.length(selected) == size * size
  // Getter used in tests
  def getMines: List[Pair[Int, Int]] = minesList
  def getSelected: List[Pair[Int, Int]] = selected

  private def neighbours(x: Int, y: Int): Int =
   List.length(
     List.filter(
       List.flatMap(
        Stream.toList(Stream.take(Stream.iterate(x - 1)(_ + 1))(3)))
        (xx => List.map(Stream.toList(Stream.take(Stream.iterate(y - 1)(_ + 1))(3)))(Pair(xx, _))))
     (List.contains(minesList, _)))

  private def placeMines(nMines: Int): Unit = if nMines > 0 then Pair(rnd.nextInt(size), rnd.nextInt(size)) match
    case p if !List.contains(minesList, p) => {minesList = Cons(p, minesList); placeMines(nMines - 1)}
    case _ => placeMines(nMines)

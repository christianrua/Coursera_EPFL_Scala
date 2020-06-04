package week6

object notes_from_week6 extends App {


  val fruit = Set("apple","banana","pear")
  val s= (1 to 6).toSet

  println(s"Values of fruit: $fruit and value of 's' is: $s")
  println(" ")
  println("Most operations on sequences are also available on Sets")

  println(s map (_ + 2))

  /*
  fruit filter (_.startsWith == "app")
  s.nonEmpty
  */

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens

    placeQueens(n)
  }

    def isSafe(col: Int, queens: List[Int]): Boolean ={
      val row = queens.length
      val queensWithRow = (row -1 to 0 by -1) zip queens
      queensWithRow forall {
        case (r, c) => col != c && math.abs(col - c) != row -r
      }
    }
    def show(queens: List[Int]) = {
      val lines =
        for (col <- queens.reverse)
          yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
      "\n" + (lines mkString "\n")
    }

  println((queens(4) map show) mkString "\n")

}

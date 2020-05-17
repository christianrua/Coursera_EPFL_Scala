package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c==0||r==0||c==r)1
    else pascal(c-1,r-1)+pascal(c,r-1)
  }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean ={

    def innerBalance(chars: List[Char], count:Int = 0): Boolean=(chars, count) match {
      case (xs, 0)  if xs.isEmpty => true
      case (xs, _)  if xs.isEmpty => false
      case (xs, count)  => xs.head match {
        case '(' => innerBalance(xs.tail, count+1)
        case ')' if count > 0 => innerBalance(xs.tail, count-1)
        case ')' => false
        case _  => innerBalance(xs.tail, count)
      }
    }

    innerBalance(chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (0, _) => 1
    case (money, _) if money < 0 => 0
    case (_, xs)  if xs.isEmpty => 0
    case (money, xs) => countChange(money - xs.head, xs) + countChange(money, xs.tail)
  }
}
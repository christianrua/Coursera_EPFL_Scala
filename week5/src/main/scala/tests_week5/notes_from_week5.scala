package tests_week5
import math.Ordering
import scala.collection.immutable.ListMap


object notes_from_week5 extends App {
  def removeAt[T](xs:List[T], n: Int): List[T] = {
    xs.filter(x => x != xs(n) )
  }

  //lt=less than
  def msort[T](xs:List[T])(implicit ord: Ordering[T]):List[T]={
    val n=xs.length/2
    if (n==0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil,ys) => ys
          case (xs, Nil) => xs
          case (x::xs1,y::ys1) =>
            if (ord.lt(x,y)) x::merge(xs1,ys)
            else y::merge(xs,ys1)
        }
        val (fst,snd) = xs splitAt n
        merge(msort(fst),msort(snd))
    }
  }

  val testList: List[Int] = List(1, 2, 3, 4)
  println("Remove At: ")
  println(removeAt(testList,0))

  val testList2: List[Int] = List(23,567,7,890,43,1)
  println("Sort list: ")
  println(msort(testList2))

  val testlist3: List[String]= List("apple","pineapple","orange","banana")
  println("Sort list whit any  data type: ")
  println(msort(testlist3))

  /*
  def squareList(xs: List[Int]): List[Int] =
    xs match {
      case Nil => Nil
      case y :: ys => y*y :: squareList(ys)
    }

   */

  def squareList(xs: List[Int]): List[Int] =
    xs map (x => x*x)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)

  }

  println("Applying the span method to a list")
  println(pack(List("a", "a", "a", "b", "c", "c", "a")))

  def encode[T](xs: List[T]): List[(T,Int)] =
    pack(xs) map (ys => (ys.head, ys.length))



  println("changing the pack method, to (element,length list) form")
  println(encode(List("a", "a", "a", "b", "c", "c", "a")))

}

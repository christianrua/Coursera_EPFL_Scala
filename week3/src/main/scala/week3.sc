
abstract class IntSet {
  def incl(x:Int):IntSet
  def contains(x:Int):Boolean
  def union(other:IntSet): IntSet
}


class NonEmpty (elem:Int, left:IntSet, rigth:IntSet) extends IntSet{
  def contains (x:Int): Boolean =
    if(x<elem) left contains x
    else if (x>elem) rigth contains x
    else true

  def incl(x:Int): IntSet=
    if(x < elem) new NonEmpty(elem, left incl x, rigth) //left.incl(x)
    else if (x > elem) new NonEmpty(elem, left, rigth incl x)
    else this

  def union(other:IntSet):IntSet =
    ((left union rigth) union other) incl elem
  override def toString = "{" + left +" "+ elem +" "+ rigth + "}"
}

class Empty extends IntSet {
  def contains(x:Int): Boolean=false
  def incl(x:Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other:IntSet):IntSet = other
  override def toString = "."
}

val t1 = new NonEmpty(3,new Empty, new Empty)
val t2 = t1 incl 4

print(t1)
print(t2)
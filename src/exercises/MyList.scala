package exercises

abstract class MyList[+A] {

  /*
    method head = first element of the list
    method tail = remainder of the list
    isEmpty: boolean = is this list empty?
    add(int) => new list wit this element added to the list
    toString => String representation of the list
   */

  def head(): A
  def tail(): MyList[A]
  def isEmpty(): Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList[Nothing] {
  def head(): Nothing = throw new NoSuchElementException
  def tail(): MyList[Nothing] = throw new NoSuchElementException
  def isEmpty(): Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons[+A](head: A, tail: MyList[A]) extends MyList[A] {
  def head(): A = head
  def tail(): MyList[A] = tail
  def isEmpty(): Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if (tail.isEmpty()) "" + head
    else head + " " + tail.printElements
  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)


}
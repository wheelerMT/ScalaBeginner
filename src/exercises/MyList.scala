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

  def map[B](transformer: Transformer[A, B]): MyList[B]

  def flatMap[B](transformer: Transformer[A, MyList[B]]): MyList[B]

  def filter(predicate: Predicate[A]): MyList[A]

  // Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

}

object Empty extends MyList[Nothing] {
  def head(): Nothing = throw new NoSuchElementException

  def tail(): MyList[Nothing] = throw new NoSuchElementException

  def isEmpty(): Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: Transformer[Nothing, B]): MyList[B] = Empty

  def flatMap[B](transformer: Transformer[Nothing, MyList[B]]): MyList[B] = Empty

  def filter(predicate: Predicate[Nothing]): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list


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

  /*
    [1, 2, 3].filter(n % 2 == 0) =
      - [2, 3].filter(n % 2 == 0) =
      - new Cons(2, [3].filter(n % 2 == 0)) =
      - new Cons(2, Empty.filter(n % 2 == 0)) =
      - new Cons(2, Empty)
   */
  def filter(predicate: Predicate[A]): MyList[A] = {
    if (predicate.test(head)) new Cons(head, tail.filter(predicate))
    else tail.filter(predicate)
  }

  /*
    [1, 2, 3].map(n * 2):
      - new Cons(2, [2, 3].map(n * 2))
      - new Cons(2, new Cons(4, [3].map(n * 2))
      - new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))
      - new Cons(2, new Cons(4, new Cons(6, Empty))
   */

  def map[B](transformer: Transformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(head), tail.map(transformer))
  }

  /*
    [1, 2] ++ [3, 4, 5]
    = new Cons(1, [2] ++ [3, 4,5])
    = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
   */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(head, tail ++ list)

  /*
    [1, 2].flatMap(n =< [n, n+1])
    = [1, 2] ++ [2].flatMap(n =< [n, n+1])
    = [1, 2] ++ [2, 3] ++ Empty.flatMap(n =< [n, n+1])
    = [1, 2] ++ [2, 3] ++ Empty
   */
  def flatMap[B](transformer: Transformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(head) ++ tail.flatMap(transformer)
  }


}

trait Predicate[-T] {
  def test(element: T): Boolean
}

trait Transformer[-A, B] {
  def transform(element: A): B
}


object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new Transformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)

  println(listOfIntegers.filter(new Predicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }))

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println((listOfIntegers.flatMap(new Transformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, Empty))
  })).toString)
}
package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Matt")
}

// Constructor
class Person(name: String, val age: Int) {
  val x = 2
  println(1 + 2)

  // Class body
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")

  // Overloading
  def greet(): Unit = println(s"Hi, I am $name.")

  // Multiple constructors
  def this(name: String) = this(name, 0)
}

// Class parameters are NOT FIELDS


/*
  Novel and a Writer Class
  Writer: first name, surname, year
  - method fullname returns concatanation of first name and surname

  Novel: name, year of release, author (Writer)
  - authorAge (age of author at year of release)
  - isWrittenBy (author)
  - copy (new year of release) = new instance of Novel with new year of release
 */

/*
  Counter class:
    - receives an Int value
    - method currrent count
    - method to increment/decrement=> new Counter
    - overload inc/dec to receive an amount =>
 */

class Writer(firstName: String, surname: String, val birthYear: Int) {
  def fullName(): String = {
    s"$firstName $surname"
  }
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge(): Int = {
    author.birthYear
  }

  def isWrittenBy: String = {
    author.fullName()
  }

  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}

class Counter(value: Int) {
  val count: Int = value

  def currentCount(): Int = {
    count
  }

  def increment(): Counter = new Counter(value + 1)
  def increment(incrementAmount: Int): Counter = new Counter(value + incrementAmount)

  def decrement(): Counter = new Counter(value - 1)
  def decrement(incrementAmount: Int): Counter = new Counter(value - incrementAmount)
}
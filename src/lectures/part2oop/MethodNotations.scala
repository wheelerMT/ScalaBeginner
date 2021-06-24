package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}."

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie)

    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def unary_! : String = s"$name, what the heck?!"

    def isAlive: Boolean = true

    def learns(skill: String): String = s"$name learns $skill"

    def learnsScala(): String = learns("Scala")

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"

    def apply(n: Int): String = s"$name watched $favouriteMovie $n times!"
  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "inception") // equivalent to above
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  // ALL METHODS ARE OPERATORS
  println(1 + 2)
  println(1.+(2))

  // Prefix notation
  val x = -1
  val y = 1.unary_-
  // unary_ perfix only works with a few operators: - + ~ !

  println(!mary)
  println(mary.unary_!)

  // Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // Apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
    1. Overload the + operator which receives a String and returns a new person with a Nickname
    mary + "the rockstar" => new Person "Mary (the rockstar)"

    2. Add an age to the Person class (default = 0), add unary + operator => new person with age + 1

    3. Add a "learns" method in the Person class => "Mary learns Scala"
    Add a learnsScala method, calls learns method with "Scala"
    Use it in postfix notation

    4. Overload the apply method to receive number and return string
    mary.apply(2) => "Mary watched $favouriteMovie 2 times".
   */

  println((mary + "the rockstar").name)

  println((+mary).age)

  println(mary learnsScala())

  println(mary(2))
}

package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahaha")
  }

  /*
    is equivalent with

    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahahaha")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon1$
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, may name is $name, how can I help?")
  }

  // Anonymous classes work for abstract AND non-abstract datatypes
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, may name is Jim, how can I be of service?")
  }
}

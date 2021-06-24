package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY

  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person) : Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // Instance-level functionality
  }

  // COMPANIONS
  println(Person.N_EYES)

  // Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val bobbie = Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args: Array[Strings]): Unit

}

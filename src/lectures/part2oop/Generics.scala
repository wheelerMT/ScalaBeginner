package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A in the class definition

    // This is essentially saying if I add an element of type B (supertype of A) then the list
    // will turn into a list of type B
    def add[B >: A](element: B): MyList[B] = ???

    /*
      A = Cat
      B = Dog = Animal
      The list will turn from a list of Cats into a list of Animals
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int] // returns MyList of type int

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // DOES LIST OF CAT ALSO EXTEND LIST OF ANIMAL??
  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // AnimalList.add(newDog)??? HARD QUESTION

  // 2. No = INVARIANCE
  class InvariantList[A]
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]  ERROR

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  // Replacing a list of cats with a list of animals:
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded types
  class Cage[A <: Animal] (animal: A) // Class cage only accepts type parameter A which are subtypes of Animal
  val cage = new Cage(new Dog)

  class Car
  // generic type needs proper bounded type
  // val newCage = new Cage(new Car)


  // expand MyList to be generic

}

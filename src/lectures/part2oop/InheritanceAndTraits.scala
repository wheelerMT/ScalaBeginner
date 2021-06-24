package lectures.part2oop

object InheritanceAndTraits extends App {

  // Single class inheritance
  class Animal {
    val creatureType: String = "wild"
    protected def eat(): Unit = println("Nom nom!")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("Crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch()

  // Constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat(): Unit = {
      super.eat()
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat()

  // Type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")

  // overRIDING vs overLOADING (make sure you know the distinction)

  // Super

  // Preventing overrides
  // 1. Use the final keyword on the member, which prevents any subclass from overriding that member
  // 2. Use the final keyword on the Class, which prevents the class from being extended.
  // 3. Seal the class (kw: sealed) = extends classes in THIS FILE, prevents extension in other files
}

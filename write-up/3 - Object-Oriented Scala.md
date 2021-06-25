# 3 - Object-Oriented Scala

## OO Basics

To instantiate a class in Scala, we use the *new* keyword:

```scala
object OOBasics extends App {

  val person = new Person
}

class Person // Empty class
```

We create a class by writing a *constructor*. We can specify parameters in the class definition:

```scala
class Person(name: String, age: Int)

var person = Person("John", 26)
```

However, class parameters are **NOT FIELDS**, meaning for the above class example we couldn't call *person.age*
since the age is not a class member. Instead, we would have to include the *val* keyword in the class constructor:

```scala
class Person(name: String, val age: Int)

var person = Person("John", 26)
println(person.age)
```

*val* and *var* definitions within a class are **FIELDS**, meaning we can call their values from their respective
object.

We can use the *this* keyword inside a class to refer to certain variables related to that class. For example, the code
below has a method called *greet* that takes in a variable name, and also uses the variable name defined for the class
itself:

```scala
class Person(name: String, val age: Int) {
  // Class body
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")
}  
```

Overloading means defining methods with the same name but different signatures:
```scala
// Overloading
  def greet(): Unit = println(s"Hi, I am $name.")
```

We can initialise different constructors of a call using the *this* keyword:
```scala
// Multiple constructors
  def this(name: String) = this(name, 0)
```

## Object Notations
In Scala we can use *infix/object notation* to write code in a natural language way. It works for methods which only 
take on parameter:
```scala
class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie
  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "inception") // equivalent to above
  // infix notation = operator notation
```

In Scala, operators such as + - etc. are not reserved, and can be used to define methods:
```scala
class Person(val name: String, favouriteMovie: String) {
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}."
  }

  // "operators" in Scala
  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
```
In Scala, **ALL OPERATORS ARE METHODS**:
```scala
// ALL OPERATORS ARE METHODS
  println(1 + 2)
  println(1.+(2))
```
The same applies to unary operators:
```scala
// Prefix notation
  val x = -1
  val y = 1.unary_-
```

Functions that recieve no parameters can be used with postfix notation:
```scala
class Person(val name: String, favouriteMovie: String) {
  def isAlive: Boolean = true
}

println(mary.isAlive)
println(mary isAlive)
```
However, we typically stick with the . version.

We can define an *apply()* method in a class, which allows us to call the class variable like a function:
```scala
// Apply
class Person(val name: String, favouriteMovie: String) {
  def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
}
  println(mary.apply())
  println(mary()) // equivalent
```

## Scala Objects
Scala objects are defined using the *object* keyword. They are a **SINGLETON INSTANCE** meaning we define them only
once. Below is an example of creating an object and calling some of its attributes:
```scala
object Person { // type + its only instance
    val N_EYES = 2
  }

  println(Person.N_EYES)

  // Scala object = SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john)
```
Since *mary* and *john* point to the same instance, the *println* statement will return *true*.

A **COMPANION** is when we generate an *object* with a *class* **in the same scope**:
```scala
object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
  }

  class Person {
    // Instance-level functionality
  }
```

We can use the *apply* method within the singleton object to create new class instances. This is called a **FACTORY 
METHOD**:
```scala
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

// Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")

  val bobbie = Person(mary, john)
```
A Scala application is a Scala object with this exact main method defined:
```scala
def main(args: Array[Strings]): Unit
```
We can use *extends App* when defining an object, which automatically includes the main method.

## Inheritance
Extending a class means inheriting all the non-private fields and methods.
```scala
class Animal {
    def eat(): Unit = println("Nom nom!")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat()
```
In this context we call Cat a *subclass* of Animal, and Animal we call a *superclass* of Cat.

Using the *protected* modifier allows the use of methods inside the subclass, but it is not accessible from outside the
class:
```scala
// Single class inheritance
  class Animal {
    protected def eat(): Unit = println("Nom nom!")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("Crunch crunch")
    }
  }
```

We can extend classes with parameters by passing in parameters to the superclass:
```scala
// Constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
```
We can override many aspects of the superclass in the subclass using the *override* keyword:
```scala
// Superclass
  class Animal {
    val creatureType: String = "wild"
    protected def eat(): Unit = println("Nom nom!")
  }

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat(): Unit = println("crunch, crunch")
  }

  val dog = new Dog("K9")
  dog.eat()

```
All instances of derived class will use the overridden things when possible.

The *super* keyword is used when you want to reference a method or a field from the superclass:
```scala
override def eat(): Unit = {
      super.eat()
      println("crunch, crunch")
    }
```
We can prevent overriding in multiple ways:
1. Use the final keyword on the member, which prevents any subclass from overriding that member
2. Use the final keyword on the Class, which prevents the class from being extended.
3. Seal the class (kw *sealed*) = extends classes in THIS FILE, prevents extension in other files

Classes which contain unimplemented or *abstract* fields or methods are called *abstract* classes, and use the 
*abstract* keyword:
```scala
// abstract
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }
```

Abstract classes **cannot be instantiated**. We would essentially just extend the abstract class and override the 
abstract fields:
```scala
class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat(): Unit = println("Crunch, crunch.")
  }
```

We can extend classes with *traits*:
```scala
// abstract
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat(): Unit = println("Crunch, crunch.")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Crocodile"

    override def eat(): Unit = println("Nom nom nom.")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")

  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
```

Classes can have both abstract and non-abstract fields, and so can traits. The difference between traits and classes is 
1. Traits cannot have constructor parameters.
2. You can only extend **ONE** class, but **MULTIPLE** traits may be inherited by the same class.
3. Traits = behaviour (what something does, carnivore etc.), abstract class = "thing" (animal etc.)

## Generics
We can define classes using *generic variables* to help us write re-usable code. For example, if we have a list class
and we want it to accept any type of parameter, e.g. Int, String etc. then we can define the class as follows:
```scala
class MyList[A] {
    // use the type A in the class definition
  }
  
  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]
```
We can declare as many generic variables in a class **AND** trait definitions as we want. 

We can also define generic methods within classes and objects:
```scala
// Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int] // MyList of type int
```

Consider the example below:
```scala
// Variance problem
  class Animal
  class cat extends Animal
  class dog extends Animal
```
A question arises: does a list of cat also extend a list of animal? There are three answers to this so-called variance
problem.
1. Yes, List[Cat] extends List[Animal]. This is called **COVARIANCE**. To define a covariance class we use the + symbol:
```scala
// 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
class CovariantList[+A]
val animal: Animal = new Cat
val animalList: CovariantList[Animal] = new CovariantList[Cat]
```
2. No = **INVARIANCE**. We define this as:
```scala
// 2. No = INVARIANCE
  class InvariantList[A]
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]  ERROR
```
3. Hello, no! This is **CONTRAVARIANCE**:
```scala
// 3. Hell, no! CONTRAVARIANCE (essentially opposite of invariance)
  class Trainer[-A]
  // Replacing a list of cats with a list of animals:
  val trainer: Trainer[Cat] = new Trainer[Animal]  
```
Bounded types allow us to use our generic classes with certain types that are a subclass of a different type of a 
superclass of a different type:
```scala
// Bounded types
class Cage[A <: Animal] (animal: A) // Class cage only accepts type parameter A which are subtypes of Animal
val cage = new Cage(new Dog)

class Car
val newCage = new Cage(new Car)
```
This is an example of an **upper-bounded** type. A **lower-bounded** type only accepts something that is a **supertype** 
of the specified argument.

One final difficult question is: if we had a list of Cats, and added a Dog to that list, what happens?  
This can be answered using the following code:
```scala
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
```
So, if we have a list of Cats and add a Dog to that list, the list then becomes a list of Animals, 
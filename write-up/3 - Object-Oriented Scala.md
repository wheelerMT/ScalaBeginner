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
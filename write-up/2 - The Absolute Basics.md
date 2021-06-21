# 2 - The Absolute Basics

## Values, Variables and Types

We can declare a value in Scala by using the **val** keyword, followed by the variable name, then type,
then finally the value:
```scala
val x: Int = 42
```
**val** objects are **IMMUTABLE**, they cannot be reassigned 
after their first assignment. 

The **type** of a **val** is _optional_. The compiler can 
infer the type for us.

We assign a variable by using the **var** keyword:
```scala
var x: Int = 4
```

Unlike values, these **can** be reassigned after their first assignment.
We can print to the console via the **println** function:
```scala
println(x)
```

## Expressions
An _instruction_ is something that we tell the computer to **DO**.
An _expression_ is something we associate with a value. For 
example:
```scala
val aCondition = true
val aConditionedValue = if(aCondition) 5 else 3
```

A code block is denoted by curly braces {}. An example:
```scala
// Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "Goodbye"
  }
```
The _value_ of the code block takes the value of the last line 
within the block itself, which will be a string within the 
above example.
Values defined within the block only have block scope, i.e. they 
**cannot** be accessed from outside the block.

## Functions
A function is defined using the *def* keyword. Each variable passed into has to have it's *type* declared, 
and the type of the function also has to be declared. The code snippet below is an example of concatenating a 
string a number together
```scala
def aFunction(a: String, b: Int): String =
    a + " " + b
```
We can call a function as we would in many other languages:
```scala
aFunction("Hello", 3)
```

Parameterless functions can be called using just their name:
```scala
def aParameterLessFunction(): Int = 42
println(aParameterLessFunction) // Be careful when using this
```

A key point of Scala programming is **USING FUNCTIONS**, therefore if you need to use loops it is better to 
use *recursive functions*:
```scala
// This is a recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
```
When declaring a recursive function, you **HAVE** to declare the type of the function (practice doing this 
for all functions regardless of if they are recursive or not).

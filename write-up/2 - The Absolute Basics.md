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

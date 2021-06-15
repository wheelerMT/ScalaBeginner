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
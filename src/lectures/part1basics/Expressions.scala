package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // Expression
  println(x)

  // Instructions (DO) vs Expressions (VALUE)

  // IF Expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3  // IF Expression NOT a construction
  print(aConditionedValue)

  var i = 0
  while (i < 1) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN ^ (just an example of a loop)

  // EVERYTHING in Scala is an Expression!
  var aVariable = 2
  val aWeirdValue: Unit = (aVariable = 3) // Unit == void

  // side effects: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "Goodbye"
  }

  // val anotherValue = z + 1 (won't work since z is defined within a code block (block scope)
}

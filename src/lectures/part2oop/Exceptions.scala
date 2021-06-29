package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this ^^ will crash with a Null Pointer Exception (NPE)

  // 1. Throwing and catching exceptions

  //  val aWeirdValue: String = throw new NullPointerException

  // Throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes.

  // 2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No Int for you!")
    else 42
  }

  val potentialFail = try {
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a Runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("Finally")
  }

  // 3. How to define your own exceptions
  class MyException extends Exception

  val exception = new MyException
  throw exception

  /*
    1. Crash your program with an OutOfMemoryerror
    2. Crash with SOError
    3. PocketCalculator
      - add(x, y)
      - subtract(x, y)
      - multiply(x, y)
      - divide(x, y)

      Throw
        - Overflow Exception if add(x, y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract exceeds Int.MIN_VALUE
        - MathCalculationException for divison by 0
   */

  // OutOfMemoryError
  // val array = Array.ofDim(Int.MaxValue)

  //  StackOverflowError
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  // Generate new exceptions
  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }
}

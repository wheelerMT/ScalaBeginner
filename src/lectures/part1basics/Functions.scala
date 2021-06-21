package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  def aParameterLessFunction(): Int = 42

  // This is a recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  // WHEN YOU NEED LOOPS, USE RECURSIVE FUNCTIONS

  println(aRepeatedFunction("hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int) = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /* 1. A greeting function {name, age} => "Hi, my name is $name and I am $age years old.
  2. Factorial function: 1 * 2 * 3 * n
  3. A Fibonacci function (1, 1, 2, 3, 5, 8...)
  4. Tests is a number is prime .*/

  def greetingFunction(aName: String, anAge: Int): String = {
    "Hi, my name is " + aName + " and I am " + anAge + " years old."
  }

  println(greetingFunction("Matt", 24))

  def factorialFunction(n: Int): Int = {
    if (n == 1) n
    else n * factorialFunction(n - 1)
  }

  println(factorialFunction(5))

  def aFibonacciFunction(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 1
    else aFibonacciFunction(n - 1) + aFibonacciFunction(n - 2)
  }

  println(aFibonacciFunction(5))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(2003)) // Is a prime
  println(isPrime(37 * 17)) // Not a prime

}
package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // VALS ARE IMMUTABLE

  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 9823791248954L // Note L at the end
  val aFloat: Float = 2.0f // Note the f at the end
  val aDouble: Double = 3.14

  // Variables:
  var aVariable: Int = 4
  aVariable = 5 // Side effects

}

package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}

object PackagingAndImports extends App {

  // Package members are accessible by their simple name
  val writer = new Writer("Matt", "RockTheJVM", 2018)

  // Import the package
  val princess = new Princess

  // Packages are ordered in hierarchy
  // They match the folder structure

  // Package object
  sayHello()
  println(SPEED_OF_LIGHT)

  // Imports
  val prince = new PrinceCharming

  // Default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}

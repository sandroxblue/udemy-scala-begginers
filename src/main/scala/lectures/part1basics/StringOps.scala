package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) //Strings are 0 indexed
  println(str.substring(7, 11)) //first number is inclusive but second one is not inclusive
  println(str.split(" ").toList) //Returns array
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString) //Prepending
  println(aNumberString :+ 'z') //Appending

  println(str.reverse)

  println(str.take(2))

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(greeting)
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)
  /*
  Examples:
    %s => String
    %d => Int
    %2.2f => 2 characters total, minimum, 2 decimals precision
   If type doesn't match it will raise an error
   */

  // raw-interpolator
  println("This is a \n newline")
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
  val rawEscaped = raw"This is a \n newline"
  println(raw"$rawEscaped")
}

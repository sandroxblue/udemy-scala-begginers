package lectures.part1basics

object ValuesVariablesTypes extends App {

  private val x: Int = 42
  println(x)

  //Vals are inmutable

  //Compiler can infer types

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false //Or true
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 12345
  val aLong: Long = 123456789101112L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //Variables
  var aVariable: Int = 4
  aVariable = 5 //Side effects
 
}

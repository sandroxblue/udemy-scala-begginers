package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  calledByValue(System.nanoTime()) //Computer evaluates parameter before calling the function
  calledByName(System.nanoTime()) //Expression passed literally and is evaluated at every use within the function

  // => delays the evaluation of expression


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //println(infinite(), 34) this will crash
  printFirst(34, infinite())

}

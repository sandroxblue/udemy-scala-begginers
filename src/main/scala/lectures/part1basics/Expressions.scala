package lectures.part1basics

object Expressions extends App{

  // EXPRESSIONS
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)
  // Math expressions + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // Relational operations == != > >= < <=

  println(!(1 == x))
  // Boolean operators ! && ||

  var aVariable = 2
  aVariable += 3 //also works with -= *= /= and only with var ... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE) - Instructions are executed and expressions are evaluated

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // This is possible because this is an if expression and not an instruction
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  // LOOPS -> evade them, they carry side efects
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN

  // EVERYTHING in Scala is an Expression! Only definition of values, class or packages are expression
  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks are also expressions and the value and type is the last line of the code
  // Everything declared inside of the codeblock only visible within the codeblock
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if(z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)

  //1. difference between "hello world" vs println("hello world")?
  // "hello world" is a value of type string and println("hello world") is an expression which is a side effect
  // that prints something to the console and its type is Unit

  //2. what is the value of this values
  val someValue = {
    2 < 3
  } // relational expression of type Boolean and equals true

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  } // 42
}

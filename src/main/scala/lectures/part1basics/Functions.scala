package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = a + " " + b

  def aFunctionWithoutReturningType(a: String, b: Int) = a + " " + b

  def aCodeBlockFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Good Morning", 1))
  println(aFunctionWithoutReturningType("Good Afternoon", 2))
  println(aCodeBlockFunction("Good Night", 3))

  def aParamaterlessFunction(): Int = 42
  println(aParamaterlessFunction())
  println(aParamaterlessFunction) //Only works in Scala 2

  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION
  // ALLWAYS PUT TYPE ON FUNCTIONS, SPECIALLY ON RECURSIVE, IT'S MANDATORY

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  println(aFunctionWithSideEffects("bye"))

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }
  println(aBigFunction(5))

  /*
    1. A greeting function (name, age) => Hi my name is $name and I am $age years old
    2. Factorial function (n) => 1 * 2 * 3 * ... * n
    3. Fibonacci function
    f(1) = 1
    f(2) = 1
    f(n) = f(n-1) + f(n-2)
    4. Tests if a number is prime
  */

  def function1(name: String, age: Int): String = s"Hi my name is $name and I am $age years old"
  println(function1("Alex", 24))

  def function2(n: Int): Int = {
    if(n == 1) n
    else n * function2(n - 1)
  }
  println(function2(4))
  println(function2(7))

  def function3(n: Int): Int = {
    if(n == 1 || n == 2) 1
    else function3(n - 1) + function3(n - 2)
  }
  println(function3(5))
  println(function3(7))

  def function4(n: Int): Boolean = {
    def auxFunction4(n: Int, x: Int): Boolean = if(x == 1) false else (n % x == 0) || auxFunction4(n, x - 1)
    !auxFunction4(n, Math.ceil(Math.sqrt(n)).toInt)
  }
  println(function4(3))
  println(function4(25))
  println(function4(37))


  //Solutions
  def greetingForKids(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old."

  println(greetingForKids("David", 12))

  def factorial(n: Int): Int =
    if(n<=0) 1
    else n * factorial(n - 1)

  println(factorial(5))

  def fibonacci(n: Int): Int =
    if(n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}

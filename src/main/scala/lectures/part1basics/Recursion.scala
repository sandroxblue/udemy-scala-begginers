package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App{

  def factorial(n: Int): Int =
    if(n <= 1) 1
    else {
      println(s"Computing factorial of $n - I first need factorial of ${n - 1}")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of $n")
      result
    }

  println(factorial(10))
  //println(factorial(5000)) StackOverflow error

  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if(x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = Use recursion call as the LAST expression

    factHelper(n, 1)
  }
  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10 * 1)
    = 1 * 2 * 3 * 4 * ... * 10
   */

  println(anotherFactorial(10))
  println(anotherFactorial(5000))
  println(anotherFactorial(20000))

  //WHEN YOU NEED LOOPS, USE TAL RECURSION

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function tail recursive
   */

  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String =
    if(n <= 0) accumulator
    else concatenateTailRec(aString, n-1, aString + accumulator)

  println(concatenateTailRec("hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if(t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(Math.ceil(Math.sqrt(n)).toInt, true)
  }

  println(isPrime(2003))

  def fibonacci (n: Int): Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, nextLast: Int): Int = {
      if(i >= n) last
      else fiboTailRec(i + 1, last + nextLast, last)
    }

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))
}

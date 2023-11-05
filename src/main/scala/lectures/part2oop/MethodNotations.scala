package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(s"$name $nickname", favoriteMovie)

    def unary_! : String = s"$name, what the heck?!"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched the movie $favoriteMovie $n times"

    def learns(thing: String): String = s"$name is learning $thing"
    def learnsScala(): String = this.learns("Scala")
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //equivalent -> infix notation = operator notation -> only works with methods with single parameter (SYNTACTIC SUGAR)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(tom + mary)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))
  // ALL OPERATORS ARE METHODS (ctrl + space gives all operators)

  // Akka actors have ! ?

  // prefix notation
  val x = -1
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(tom.unary_!)

  // postfix notation - rarely used and only available on functions with no operators
  println(mary.isAlive)
  println(tom isAlive) //import scala.language.postfixOps

  // apply()
  println(mary.apply())
  println(tom()) //equivalent

  /*
    1. Overload the + operator -> mary + "the rockstar" => new Person("Mary the rockstar", favorite movie)
    2. Add an age to the Person class and add unary + operator => new Person with age + 1 => +mary
    3. Add learns method => mary learns Scala
       Add learnsScala method, calls learns method with Scala and use it in postFix notation
    4. mary.apply(2) => "Mary watched Inception 2 times"
   */

  println((mary + "the Rockstar")())
  println(+mary.age) //returns 0
  println((+mary).age) //returns 1
  println(mary learnsScala())
  println(mary(2))

}

package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Alex", 24) //Instantiated class
  println(person.age)

  person.greet("Stefano")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel. authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter)) //Do we want this to happen?


  val counter = new AnotherCounter
  counter.inc().print()
  counter.inc().inc().inc().print()
  counter.inc(10).print()
}

//constructor
class Person(name: String, val age: Int) {

  // body
  val x = 2 // field

  println(1 + 3) // all side effects will be executed when instantiate class

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // Use this to differentiate between your fields and parameters - kills ambiguity

  //Overloading - functions with same name but different signature = different number/type of parameters
  def greet(): Unit = println(s"Hi, I am $name")
  //def greet(): Int = 42 this is not overloading - compile error

  //Multiple constructors - overload constructor
  def this(name: String) = this(name, 0) //If we use it to get default parameters we could simply put a default value on main constructor
  def this() = this("Jhon Doe")

}

// class parameters are NOT FIELDS - to convert it to fields you need to add val

/*
  Novel and a Writer class
    Writer: first name, surname, year
      - method fullname
    Novel: name, year of release, author
      - method authorAge, isWrittenBy(author), copy(new year of release) = new instance of Novel with nwe year of release
*/

class Writer(val firstName: String, val surname: String, val year: Int) {

  def fullName: String = s"$firstName $surname"

}

class Novel(name: String, year: Int, author: Writer){

  def authorAge: Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)

}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dev to receive an amount => new Counter
 */

class Counter(count: Int){

  def currentCount: Int = count

  def inc(): Counter = new Counter(count + 1) // inmutability
  def dec(): Counter = new Counter(count - 1)

  def inc(n: Int): Counter = new Counter(count + n)
  def dec(n: Int): Counter = new Counter(count - n)

}

class AnotherCounter(count: Int = 0){

  def currentCount: Int = count

  def inc(): AnotherCounter = {
    println("incrementing")
    new AnotherCounter(count + 1)
  }

  def dec(): AnotherCounter = {
    println("decrementing")
    new AnotherCounter(count - 1)
  }

  def inc(n: Int): AnotherCounter = {
    if(n <= 0) this
    else inc().inc(n-1)
  }

  def dec(n: Int): AnotherCounter = {
    if (n <= 0) this
    else dec().dec(n - 1)
  }

  def print(): Unit = println(count)

}
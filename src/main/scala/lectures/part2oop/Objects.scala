package lectures.part2oop

object Objects extends App{

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  //But has an equivalent => Object

  //An object can have val, vars and methods
  object Person { //type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person, name: String): Person = new Person(name)
  }

  class Person(val name: String) {
    //Instance-leven functionality
  }

  //COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = Person
  val jhon = Person
  println(mary == jhon) //Both point to the same instance

  val christine = new Person("Christine")
  val julian = new Person("Julian")
  println(christine == julian) //They don't point to the same instance

  val bobbie = Person.apply(christine, julian, "bobbie")
  val frankie = Person(christine, julian, "bobbie")

  // Scala applications => why this is playable
  // Scala object with def main(args: Array[String]): Unit
}

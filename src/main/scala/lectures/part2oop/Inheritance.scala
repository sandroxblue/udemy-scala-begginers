package lectures.part2oop

object Inheritance extends App{

  //single class inheritance
  sealed class Animal {
    val creatureType = "wild"

    def eat(): Unit = println("nomnom") //public
    final private def sleep(): Unit = println("zzzz")
    protected def drink(): Unit = println("gulp")
  }

  class Hamster extends Animal {
    def crunch(): Unit = {
      eat()
      drink()
      println("crunch")
    }
  }

  val hamster = new Hamster
  hamster.eat()
  // cat.drink -> error
  // cat.sleep -> error
  hamster.crunch()

  // Constructors
  class Person (name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult (name: String, age: Int, idCard: String) extends Person(name, age)
  class Baby (name: String, age: Int, idCard: String) extends Person(name)


  // Overriding
  class Cat extends Animal {
    override val creatureType: String = "domestic"

    override def eat(): Unit = println("crunch, crunch")
  }

  class Dog (override val creatureType: String) extends Animal {
    override def eat(): Unit = {
      super.eat()
      println("crunch, crunch")
    }

    // override def sleep - error
  }

  val cat = new Cat
  cat.eat()
  println(cat.creatureType)

  val dog = new Dog("domestic")

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat()

  // overRIDING != overLOADING

  // Super

  // preventing overrides
  // 1.- Use keyword "final" on member
  // 2.- Use keyword "final" on the entire class
  // 3.- Seal the class = extend classes in this file. prevents extension in other files


}

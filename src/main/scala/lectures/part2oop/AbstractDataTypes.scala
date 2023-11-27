package lectures.part2oop

object AbstractDataTypes extends App{

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  // val animal = new Animal -> ERROR

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    //override is optional here
    def eat: Unit = println("crunch crunch")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit

    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Reptile"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //Traits vs Abstract classes
  // 1.- Traits do not have constructor parameters
  // 2.- You can extend multiple traits but only one class
  // 3.- traits = behavior /vs/ abstract class = type of thing
}

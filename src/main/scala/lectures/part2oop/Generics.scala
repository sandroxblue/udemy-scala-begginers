package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    If
      A = Cat
      B = Dog = Animal
    And I add a Dog into a list of cats, it turns into a list of animals
     */
  }

  class MyMap[Key, Value] {
    // Use the type Key and Value
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //IF B EXTENDS A, SHOULD LIST[B] EXTEND LIST[A]

  //1. YES List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog)??? -> HARD QUESTION -> would turn it into a list of Animals

  //2. NO List[Cat] != List[Animal] = INVARIANCE
  class InvariantList[A]
  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] - ERROR

  //3. HELL NO = CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal] //You have s a trainer of animals to train cats


  //Bounded Types
  class Cage[A <: Animal](animal: A) //Only accepts subtypes of Animal -> >: only accepts superTypes of Animal
  val dogCage = new Cage(new Dog)
  val catCage = new Cage(new Cat)

  class Car
  //val newCage = new Cage(new Car) // THIS WILL GIVE ERROR


  //expand MyList to be generic
}

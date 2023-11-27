package exercises

abstract class MyGenericList[+A] {

  /*
      head: Int = first element of the list
      tail: Int = remainder of the list
      isEmpty: Boolean = is this list empty
      add(int): List = new list with element added
      override toString: Unit = string representation of the list
   */

  def head: A
  def tail: MyGenericList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyGenericList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object GenericEmpty extends MyGenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()

  def tail: MyGenericList[Nothing] = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyGenericList[B] = new GenericCons(element, GenericEmpty)

  def printElements: String = ""
}

class GenericCons[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
  def head: A = h

  def tail: MyGenericList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyGenericList[B] = new GenericCons(element, this)

  def printElements: String = {
    if(t.isEmpty) h + ""
    else h + " " + t.printElements
  }
}

object GenericListTest extends App {
  val listOfIntegers: MyGenericList[Int] = new GenericCons(1, new GenericCons(2, new GenericCons(3, GenericEmpty)))
  val listOfStrings: MyGenericList[String]= new GenericCons("Hello", new GenericCons("Scala", GenericEmpty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int = if(n <= 1) acc else trFact(n - 1, n * acc)

  val fact10 = trFact(10, 1) //acc is 1 all the time, we can use default arguments to simplify the use
  val fact12 = trFact(12)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture...") //let's assume jpg full HD is the most usual format

  savePicture("jpg", 800, 600)
  //savePicture(800, 600) won't work because can't tell which parameter 800 stands for

  /*
  Solutions:
    1. pass in every leading argument
    2. name the arguments
   */

  savePicture(width = 800)
  savePicture(height = 600, width = 800, format = "bmp") // We can change order because we are specifying the name of the arguments

}

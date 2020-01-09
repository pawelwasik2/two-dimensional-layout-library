import Element.elem

abstract class Element {
  //We cannot instantiate an abstract class.
  def contents: Array[String]
  //this functions does not have an abstract abstract modifier, thus method is abstract when does not have an implementation:
  //i.e. no equal sign = or body in {}

  //Class Element DECLARES the abstract method contents, but currently DEFINES no concrete methods

  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  //those 3 methods has not a parameter list, not even an empty one, those methods are PARAMETERLESS methods
  //def height(): Int =.... would be called empty-param method

  //PL: ZASADA JEDNOLITEGO DOSTĘPU:
  //Chodzi w głównej mierze o to, by metody bezargumentowe oraz bez efektów ubocznych zapisywać bez nawiasów, jednak
  //jednak NIE WOLNO zapisywać metody, która ma efekty uboczne, bez nawiasów ponieważ bedzie wprowadzać w bład
  //Podobnie, jesli chcemy wywolac funckje z efektem ubocznym, nalezy uzyc nawiasów np: println() no i wiadomo, odwrotnie

  def above(that: Element): Element =
    elem(this.contents ++ that.contents)

  def beside(that: Element): Element = {
    elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  }

  override def toString = contents mkString "\n"

}

class ArrayElement(
  val consts: Array[String]
) extends Element
  //I have no idea where const is stored. In def? why not val?
  //Moze chodzi o to, ze te nawiasy to juz w sumia sa konstruktorem i przypisuja do wartosci const te tablice,
  //dzieki temu mozna by tej zmiennej const uzywac pozniej w funkcjach itd, chyba o to chodzi
  //PL: Oke, chodzi o to, że zmienną const możemy poslugiwać się tylko w metodach w tej klasie, jesli chcielibysmy wyswietlic
  //const z poziomu innej klasy czy cos to nie ma szans


//class ArrayElement inherit all non-private members from class Element,
// and it makes the type ArrayElement a subtype of the type Element.

//It's not allowed to make a method and a field with the same name in the same class in Scala
//By contrast, Scala's two namespaces are:
//• values (fields, methods, packages, and singleton objects)
//• types (class and trait names)
//You can ovverride def's with vals but u cant override val's with def's

/*** Single parametric field definition
  * class ArrayElement(
  *   val contents: Array[String]
  * ) extends Element
  *
  * It works too
  */
//Example
/*class Cat {
  val dangerous = false
}
class Tiger{
  override val dangerous: Boolean,
  var age: Int
}extends Cat
*/

// It's a shortcut of:
// class Tiger(param1: Boolean, param2: Int) extends Cat {
// override val dangerous = param1
// private var age = param2
// }

class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}

//When client want to make element with a single line.
//Since LineElement extends ArrayElement, and ArrayElement's constructor takes a parameter
//(anArray[String]), LineElement needs to pass an argument to the primary constructor of its superclass.

class UniformElement(ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}

//modifier "final" means that field cannot be overrided by subclasses:
//final override def demo() = {
// println("ArrayElement's implementation invoked")
// }

//for classes:
//final class ArrayElement .........

// companion object - factory object
object Element {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElement(line)
}
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
}

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
  //I have no idea where const is stored. In def? why not val?
}
//class ArrayElement inherit all non-private members from class Element,
// and it makes the type ArrayElement a subtype of the type Element.

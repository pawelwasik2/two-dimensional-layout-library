object Main extends App {
  val ae = new ArrayElement(Array("hello", "world"))
  println(ae.width)
  println(ae.height)

  //Subtyping means that a value of the subclass can be used wherever a value of the superclass is required. For example:
  val e: Element = new ArrayElement(Array("hello"))
  //type ArrayElement is compatibile with Element cause class ArrayElement extends class Element

}

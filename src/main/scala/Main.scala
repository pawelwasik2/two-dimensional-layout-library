object Main extends App {
  val ae = new ArrayElement(Array("hello", "world"))
  println(ae.width)
  println(ae.height)

  //Subtyping means that a value of the subclass can be used wherever a value of the superclass is required. For example:
  val e: Element = new ArrayElement(Array("hello"))
  //type ArrayElement is compatibile with Element cause class ArrayElement extends class Element

  //println(ae.const) Gives error cause of we can only use "const" in the body of this class, not from outside
  //we should make a new field i.e. val arr = const and we could use ae.arr
}

package model.counter

case class Counter(val count: Int = 0) {

  def inc: Counter = inc()
  def dec: Counter = dec()
  def inc(x: Int = 1): Counter = copy(count = count + x)
  def dec(x: Int = 1): Counter = copy(count = count - x)
  def adjust(adder: Adder) =
    copy(count = adder.add(count))

}

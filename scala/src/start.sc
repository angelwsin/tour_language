
//https://docs.scala-lang.org/tour/tour-of-scala.html
//-------Expressions 表达式

1+1

print(1+1) //输出


//------常量 val 类似java  final

val  x =   1

     //x = 2; 编译错误 常量

// 不用指定类型  类型推导

//  显示指定

val  y : Int =  2


//-------变量  var

var  z = 1 + 4

     z = 8

//显示 指定类型

var  i: Int = 9

//-------块{}  代码块

print({
  val x = 1 + 1
  x + 1
})


//--------函数  Functions

//1) 匿名函数   参数列表=> 表达式

(x:Int)=> 1+1

//2) 指定函数名

var  f = (y:Int)=> y+1

print(f(1))

//3) 多参数的函数

var  mf  = (x:Int,y:Int)=> x+y


//4) 无参的函数

var  vf = ()=> 1+1


//---------方法 methods   方法和函数的不同
//1) 关键字 方法 def

//Methods are defined with the def keyword. def is followed by a name, parameter lists, a return type, and a body.
def add(x: Int, y: Int): Int = x + y
println(add(1, 2)) // 3


// 2)多参数
def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(1, 2)(3)) // 9

//3)无参
def name: String = System.getProperty("user.name")
println("Hello, " + name + "!")

//4)方法体

def getSquareString(input: Double): String = {
  val square = input * input
  square.toString
}
//The last expression in the body is the method’s return value. (Scala does have a return keyword, but it’s rarely used.)
// 默认有 return


//----------Classes  关键字 class name and constructor parameters.

//1)定义
//最小类定义只是关键字class和标识符。类名应大写
//默认无参构造方法
class User

val user1 = new User


class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}

//Unit 类似java void

//2)构造方法  可设定默认值

class Point(var x: Int = 0, var y: Int = 0)

val origin = new Point  // x and y are both set to 0
val point1 = new Point(1)
println(point1.x)  // prints 1


//在此版本的Point类中，x并y具有默认值，0因此不需要参数。但是，因为构造函数从左到右读取参数，所以如果您只想传入一个y值，则需要为参数命名。

val point2 = new Point(y=2)
println(point2.y)  // prints 2

//3)私有成员和Getter / Setter语法
//会员默认是公开的。使用private访问修饰符将其隐藏在类外部。

class Pointx {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}

val point4 = new Pointx
point4.x = 99
point4.y = 101 // prints the warning

//在这个版本中的Point类，数据存储在私有变量_x和_y。有方法def x和def y访问私人数据。
// def x_=并且def y_=是用于验证和设置的值_x和_y。请注意setter的特殊语法：该方法已_=附加到getter的标识符和后面的参数


//2) 实例化 new
val greeter = new Greeter("Hello, ", "!")
greeter.greet("Scala developer") // Hello, Scala developer!



// case 类型

//Scala有一种特殊类型的类，称为“case”类。默认情况下，case类是不可变的，并按值进行比较。您可以使用case class关键字定义

case class Pointc(x: Int, y: Int)
//您可以在没有new关键字的情况下实例化案例类。

val point = Pointc(1, 2)
val anotherPoint = Pointc(1, 2)
val yetAnotherPoint = Pointc(2, 2)
//并且它们按价值进行比较。

if (point == anotherPoint) {
  println(point + " and " + anotherPoint + " are the same.")
} else {
  println(point + " and " + anotherPoint + " are different.")
} // Point(1,2) and Point(1,2) are the same.

if (point == yetAnotherPoint) {
  println(point + " and " + yetAnotherPoint + " are the same.")
} else {
  println(point + " and " + yetAnotherPoint + " are different.")
} // Point(1,2) and Point(2,2) are different.








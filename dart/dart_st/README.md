A sample command-line application.

Created from templates made available by Stagehand under a BSD-style
[license](https://github.com/dart-lang/stagehand/blob/master/LICENSE).


dart 环境搭建

安装 dartsdk
ideal 安装dart插件

脚手架管理工具安装 stagehand
 pub global activate stagehand


 https://dart.dev/samples


 dart 
  实现类型安全的，不需要显示指定类型，有类型推导  方法上的参数和返回值推荐显示指定类型


 二.语言使用的字符集
UTF-16

三.语法 词法
行结构（逻辑行和物理行）
  使用;
注释
 单行  //   多行注释 /* ....*/
标识符
关键字：https://dart.dev/guides/language/language-tour
  abstract（抽象类） 	dynamic（允许任何对象，泛型<>or 参数等） 	implements（实现类） 	show 
  as 	else	import 	static 
  assert	enum	in	super
  async 	export 	interface 	switch
  await 	extends	is	sync 
  break	external 	library 	this
  case	factory 	mixin 	throw
  catch	false	new	true
  class	final	null	try
  const	finally	on 	typedef 
  continue	for	operator 	var
  covariant 	Function 	part 	void
  default	get 	rethrow	while
  deferred 	hide 	return	with
  do	if	set 	yield 
Literals 字面量; 常量
操作符Operators（运算符 算数运算符 逻辑运算符 条件运算符 赋值运算符）
       算数：
       Operator	Meaning
           +	Add
           –	Subtract
          -expr	Unary minus, also known as negation (reverse the sign of the expression)
            *	Multiply
            /	Divide
           ~/	Divide, returning an integer result
           %	Get the remainder of an integer division (modulo)
        Operator	Meaning
           ++var	var = var + 1 (expression value is var + 1)
           var++	var = var + 1 (expression value is var)
           --var	var = var – 1 (expression value is var – 1)
           var--	var = var – 1 (expression value is var)
        比较：
        Operator	Meaning
              ==	Equal; see discussion below
              !=	Not equal
               >	Greater than
               <	Less than
              >=	Greater than or equal to
              <=	Less than or equal to
        类型测试：
        Operator	Meaning
              as	Typecast (also used to specify library prefixes)
              is	True if the object has the specified type
             is!	False if the object has the specified type
        赋值运算符：
        // Assign value to b if b is null; otherwise, b stays the same
        b ??= value;
        =	–=	/=	%=	>>=	^=
        +=	*=	~/=	<<=	&=	|=
        逻辑：
        Operator	Meaning
           !expr	inverts the following expression (changes false to true, and vice versa)
              ||	logical OR
              &&	logical AND
        位运算：
        Operator	Meaning
               &	AND
               |	OR
               ^	XOR
             ~expr	Unary bitwise complement (0s become 1s; 1s become 0s)
              <<	Shift left
              >>	Shift right
        条件：
        condition ? expr1 : expr2
        expr1 ?? expr2
        If expr1 is non-null, returns its value; otherwise, evaluates and returns the value of expr2.
        其他：
        Operator	Name	Meaning
              ()	Function application	Represents a function call
              []	List access	Refers to the value at the specified index in the list
               .	Member access	Refers to a property of an expression; example: foo.bar selects property bar from          expression foo
               ?.	Conditional member access	Like ., but the leftmost operand can be null; example: foo?.bar selects        property bar from expression foo unless foo is null (in which case the value of foo?.bar is null)

流程控制：
if and else：if(){}else if(){}
for loops: for(var x in list){}
while and do-while loops:
break and continue:
switch and case:
assert:
四.数据模型（包括内置对象）
内置类型：                            所在的库
numbers：int double                 dart:math
strings:  '' or  """ """  使用${var}or $var 字符串连接使用+  如果是var是对象是toString()方法  使用== 判断
booleans: bool  literals true and false
lists (also known as arrays):[1,2,...] or List<>  操作[...list] 插入list集合 
sets: {} or  Set<> or <>{}
maps:{key:value} or Map<k,v>
runes (for expressing Unicode characters in a string):UTF-32 code points of a string
symbols:#  标记

values-types
Functions：一切皆对象 Function   
         one expression  The => expr syntax is a shorthand for { return expr; }
         一.使用变量名
         参数 Optional named parameters：paramName: value
         定义 f({param1, param2, …})  调用f(param1:vlaue1,param2:value2,...)
         可以使用 @required 限定参数：package:meta/meta.dar
         二.使用位置Optional positional parameters
         Wrapping a set of function parameters in []
         f([...])

         默认参数值：Default parameter values 如果没指定赋值为null
         定义f({bool bold = false, bool hidden = false}) 如变量 bold= false 默认
         
         特殊方法main
          1)void main(){}
          2)void main(List<String> arguments){}

        方法可以作为参数传递：Functions as first-class objects
        匿名方法:Anonymous functions
         ([[Type] param1[, …]]) { 
            codeBlock; 
          }; 
        方法内可以嵌套方法：f(){ fun(){}}
        方法中变量的作用域：
        方法的作用域及调用：全局方法 实例方法 static静态方法类方法
        返回值： 
         f(){} 返回值为：null
        异步方法：https://www.jianshu.com/p/024d7e604edd
enum 枚举：
Callable classes： 可调用的类
     To allow an instance of your Dart class to be called like a function, implement the call() method.



面向对象：对象继承 抽象 封装 多态
dart是面向对象的，多继承 所有的类是继承Object
封装：
      对象成员使用.：the method has access to that object’s functions and data
         如 p.y 
      _开头代表私有
      构造函数：
       Constructor names can be either ClassName or ClassName.identifier：
         如 Point() and Point.fromJson() constructors
         Point(num x, num y) {
         // There's a better way to do this, stay tuned.
         this.x = x;
         this.y = y;
         }
        可以写成 Point(this.x, this.y);
        默认无参构造函数：
        Named constructors：ClassName.identifier
        构造函数调用：super()
          initializer list： constructor():...
          superclass’s no-arg constructor
          main class’s no-arg constructor
        Constant构造函数：const constructor()：
          all instance variables are final
        Factory构造函数：factory constructor()
              a factory constructor might return an instance from a cache, or it might return an instance of a subtype
      对象类型：use Object’s runtimeType property, which returns a Type object.
         如 obj.runtimeType
     
    方法：
      实例方法：
      抽象方法： void f();
      Getters and setters方法：  get field , set (){}
    
    修饰符： static 

    抽象： Abstract classes  interface
        重新操作符： operator +（）{}
        <	+	|	[]
        >	/	^	[]=
        <=	~/	&	~
        >=	*	<<	==
        –	%	>>

    继承： 多继承     a extend b  with b ,c {}



五.import  依赖管理

import 导入包
Libraries and visibility
https://dart.dev/guides/libraries/create-library-packages


六.加载 运行时 异常
异常Execetption：Error or Exception.
   throw:
   try{}on Exception{}
   try{}on Exception catch(e,s){}    //s 代表异常的堆栈
   try{}catch(e){}
   try{}finally{}
   rethrow:

dart 运行时：编译
https://dart.dev/platforms 


Dart Native: For programs targeting devices (mobile, desktop, server, and more), Dart Native includes both a Dart VM with JIT (just-in-time) compilation and an AOT (ahead-of-time) compiler for producing machine code.
Dart Web: For programs targeting the web, Dart Web includes both a development time compiler (dartdevc) and a production time compiler (dart2js).

垃圾收集：分代收集



七.核心库（包括 线程 文件 net 同步）

Asynchrony support 异步支持：
Dart 是单线程的，主线程由一个事件循环来执行

dart 核心库：https://dart.dev/guides/libraries/library-tour#dartasync---asynchronous-programming

八.特性
泛型<>
Generators 生成器
  When you need to lazily produce a sequence of values, consider using a generator function. Dart has built-in support for two kinds of generator functions:

   Synchronous generator: Returns an Iterable object.
   Asynchronous generator: Returns a Stream object.
         To implement an asynchronous generator function, mark the function body as async*, and use yield statements to deliver values:
         If your generator is recursive, you can improve its performance by using yield*: 递归方法

    同步：
    Iterable<int> naturalsTo(int n) sync* {
      int k = 0;
      while (k < n) yield k++;
    }
    异步：
    Stream<int> asynchronousNaturalsTo(int n) async* {
       int k = 0;
       while (k < n) yield k++;
     }
    递归同步：
    Iterable<int> naturalsDownFrom(int n) sync* {
       if (n > 0) {
        yield n;
        yield* naturalsDownFrom(n - 1);
       }
    }

Isolates 隔离 多线程
dart使用消息机制而不是共享内存模型
Instead of threads, all Dart code runs inside of isolates. Each isolate has its own memory heap



Typedefs 方法定义别名












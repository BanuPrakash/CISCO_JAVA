# JAVA
Banuprakash C

Full Stack Architect, Corporate Trainer

Co-founder & CTO: Lucida Technologies Pvt Ltd., 

https://www.lucidatechnologies.com/

https://www.linkedin.com/in/banu-prakash-50416019/


Emails: 
banuprakashc@yahoo.co.in

banuprakash.cr@gmail.com

banu@lucidatechnologies.com

Repository for Training:
https://github.com/BanuPrakash/CISCO_JAVA

===================================


Softwares Required:
1)  openJDK 17
https://jdk.java.net/java-se-ri/17

Setting UP: https://www.youtube.com/watch?v=p4ijugQ_3EI

java --version

2) IntelliJ Ultimate edition 
https://www.jetbrains.com/idea/download/?section=mac

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

```
* OOP
* Java Collection Framework and streams
* Concurrency
* Maven build tool and JDBC

==============================

Object Oriented Programming:
* Object : state and behaviour
Tv Object as example: 
state: on / off, channel, volume, brightness, ...
behaviour / action / messages: on/off, changeChannel, increase/decrease ...

Object communicate with other objects by sending messages

What messages an object can accept is exposed thro its interface.

Thinking in Object; Templates for object --> class / function / Type ,...
```
class Tv {
    state
    behaviour
}

function Tv() {
    state
    behaviour
}

Type Tv 

End Type
```

SOLID Design Principle

S --> Single Responsibility
O --> Open Close Principle; component/object should be closed for change but open for extension
L --> Liskov substitution Principle; In Generalization and Specailization relationship, at any point of time and Specialized object can replace a generalized one in order to get the work done.
I --> Interface segreggation; Abstraction 
D --> Dependency Injection; Inversion Of Control; needs Service Providers

=========================================

What is Java?
Java --> Technology; platform provides APIs  to execute byte code
To generate a byte code we write a program and compile it

Java programming language --> java compiler --> byte code
Kotlin programming language --> kotlin compiler --> byte code
Groovy programming language --> groovy compiler --> byte code

===========

Account.java
```
   public class Account {
        private double balance; // state

        // action / message / behaviour / instance method
        // mutation
        public void deposit(double amt) {
            balance += amt;
        }

        // accessor
        public double getBalance() {
            return balance;
        }
   } 
```

javac Account.java --> Account.class

AccountExample.java
```
    public class AccountExample {
        public static void main(String args[]) {
            Account rahulAcc = new Account(); // new keyword for DMA {HEAP}
            rahulAcc.deposit(5000);
            System.out.println(rahulAcc.getBalance());

            Account swethaAcc = new Account(); // new keyword for DMA {HEAP}
            swethaAcc.deposit(9000);
            System.out.println(swethaAcc.getBalance());
        }
    }

```

javac AccountExample.java ---> AccountExample.class

================

JRE: Java Runtime Environment
java AccountExample {make sure this class contains main()}  

```
Part 1: ClassLoader: Secondary Storage --> Primary Storage
* findLoadedClass()
* loadClass() --> defineClass() [ convert byte code to platform specific data structure  / code]

loadClass() checks current folder or CLASSPATH environment variable
set CLASSPATH = \users\banu\projects; \users/banu\libraries;..

* findSystemClass() --> defineClass()

Platform can be Mobile / Elevator / Access Card / Tv / Laptop .. Target machine
byte code --> Platform independent  and architecture neutral; portable
Output of defineClass() is platform specific code
```

data allocated on HEAP area will have default values;
int to 0; double to 0.0; objects to null ; character to null character; boolean to false;

No concept of garbage or junk value in heap area

```
context.behaviour(arguments);
fan.on();
tv.on();
tv.changeChannel(454);
rahulAcc.deposit(5000); ==> deposit(rahulAcc, 5000);
```
============

Logically group objects/classes in building enterprise application
* Entity / model / domain classes
they are used to represent the state which is long lived; beyoud the life of application
they are associated with persistent store like database / file ...
Most of the time one class per table in database.

Example: Uber application
Customer, Driver, Vehicle, Trip, Payment, ...

Example : Amazon
Customer, Product, Supplier, Order, LineItems, ...

Generally these classes won't have any business logic.
they contain constructors, getters, setters, hashCode, equals, toString method

https://datamodels.databases.biz/

* DAO / DAL classes: Data Access Object
They contain CRUD operations
CREATE READ UPDATE DELETE

* Business : business logic

* Service : facade over business and DAO layer
generally they contain transactional code; making coarse grained layer

```
// one call from client / UI
public void transferFunds(Account fromAcc, Account toAcc, double amt) {
    BEGIN Tx
    // check eligibility --> business layer
    // check balance --> call to DAO layer
    // update fromAcc --> call to DAO layer
    // insert into Tx table --> call to DAO layer
    // send SMS 
    COMMIT Tx
}

```
* UI : user interface / client code

* Exception classes
an object which tells
1) What went wrong?
2) Why?
3) Where?

* Utility : helper classes

package: in java it's a folder for logically grouping of classes
they also help in class namespace identification

Date d; // ??

java.util.Date d1 ...
java.sql.Date d2 ...

```
com
    cisco
        prj
            entity
                Customer.java
                Order.java
                ...
            dao [one per table]
                CustomerDao.java
                OrderDao.java
                ...
            service [one per actor]
                AdminService.java
                CustomerService.java
            utility
                ..
            exception
                ...
            business
                ...
```


IntelliJ --> New Project --> Java --> IntelliJ Project


Primitive types: reside on stack
reference types: reside on heap are

===============

constructors:
1) used to initailze objects
2) can be overloaded: can have different ways to initialize
3) they look like methods  having same name as that of class
4) they implitily returns the created object
5) can't be void
6) compiler creates default constructor if no constructors are written

I need to keep track of how many instances of Account is created
static : class data
instance: object data

rahulAcc.getBalance(); ===> getBalance(rahulAcc); // internally rahulAcc -> this pointer

Account.getCount(); ==> getCount(); // no explict passing of this pointer; hence static methods can't access state

rahulAcc.getCount(); ==> Account.getCount(); 

---

local variables --> stack
instance variables --> heap
static variables --> metaspace / earlier it was called as method area

=================================================

Every class inherits from java.lang.Object class
important methods of Object class:
equals, hashCode, toString, getClass,   wait, notify, notifyAll

entity classes should override equals, hashCode, toString [ used only in development env]

===================================

Relationship between objects / classes

* Generalization and Specialization [ IS A] 
* Association [ HAS A]
* Realization
* Uses A 

Java Build tools:
* Maven
* checkstyle: Coding conventions
* PMD / findBugs: Coding Stds
* SonarQube
* Jenkins [ CI / CD]

PMD / findBugs / SonarQube: --> Copy & Paste Code

https://www.youtube.com/watch?v=hXkzfLaps8s

=========================================

* Generalization and Specialization [ IS A] 
--> Inheritance
--> extends is the keyword in Java
--> every object is inherited from java.lang.Object [implicit]
public class Account
translates to:
public class Account extends Object
--> java doesn't support multiple inheritance
public class A extends B, C { // not valid

====

In Java all instance methods internally are virtual functions; all instance methods are dynamic binding

```
Mobile[] mobiles = new Mobile[100];
...
for(i = 0; i < mobiles.length; i++) {

}
Tv[] tvs = new Tv[1000];
for(i = 0; i < tv.length; i++) {
    
}

```

Product p = new Mobile();
instanceof --> family of

p instanceof Mobile ===> evaluate to true
p instanceof Product ==> true
p instanceof Object ==> true
p instanceof Tv ==> false

p.getClass() ===> Mobile.class

====================================

abstract class and abstract methods:
abstract class: classes which are meant only for generalization; objects of such classes doesn't exist in real world
Examples: Product, Account,..
cannot be instantiated

abstract methods: pure virtual functions; no method body;
all inherited classes need to implement them or mark the inherited class also as abstract

Rule:
* if one of the method is abstract then class has to be declared abstract

* abstract class need not have abstract methods
====

Realization relationship
* A component will realize the behaviour specified by other
* program to contract
* program to interface

In java we do it using interface

interface interfaceName {
    abstract behaviour
}

===========
// all methods in interface are by default public and abstract

```
interface EmployeeDao {
    void addEmployee(Employee e);
    Employee getEmployee(int id);
}

implements ==> Realization

public class EmployeeDaoDbImpl implements EmployeeDao {
    public void addEmployee(Employee e) { insert  }
    public Employee getEmployee(int id) { select }
}


UI code:

click on add button

employeeDao.addEmployee(e);

employeeDao.getEmployee(34);

```

Why program to interface?
1) DESIGN
2) IMPLEMENTATION
3) TESTING
4) INTEGRATION
5) LOOSE COUPLING

Scenario 1:
Switching between strategies
MobileDao mobileDao = new MobileDaoDbImpl();
OR
MobileDao mobileDao = new MobileDaoMongoImpl();

Issues: There are many heterogenous clients like Web, Mobile, Desktop, Tv ...
Switching between strageties needs every client code to change.
No abstraction; Why should client know about type of implementation
No consistency; some will update to Mongo, other clients might still be use DB. ---> issue

Solution : Use Factory Pattern
Every client code :
MobileDao mobileDao = MobileDaoFactory.getMobileDao();

Zero changes in client

Scenario 2:
No code changes, even in Factory
Solution: use Configuration files like XML / properties, ...
for XML we need to learn SAX / DOM,
properties file is a key/value pair
MOBILE_DAO=com.cisco.prj.dao.MobileDaoDbImpl



Creating an Object:
1) if we know class name 
new Mobile()

2) if class name is dynamic
str = "com.cisco.prj.entity.Tv"

Class.forName(str).newInstance();

=========================================

Day 2

Recap:
SOLID 
JRE: JVM, Metaspace, Stack, Heap.
Implict "this" reference passed as first argument to instance methods only and not to static methods
instance variables vs static/class variable
constructor, super, static block

Generalization and Specialization relationship --> IS A --> Inheritance --> extends
* Java doesn't support multiple inheritance
* every class inherits java.lang.Object
abstract class and abstract methods

Realization Relationship: implements 
Factory Methods for decoupling

Reflection API:
anyObject.getClass().getMethod(); // gets all the methods including inherited methods of the class for a given object.
method.invoke(object); // if method name is dynamic

// we can create object of a class if we don't know the name is advance
Class.forName("fully-qualified-class-name").getConstructor().newInstance();

====================================================================

* Realization Relationship vs Generalization and Specialization
* Interface Segreggation
* interfaces for OCP

Anonymous classes can be created from interface or abstract classes
classes are created on the fly within JRE; once object is created of that class, classdata can be removed from metaspace

If interface has only one method to implement; its called FunctionalInterface; for such interfaces we can use lambda expressions instead of anonymous class approach.

===================================

Introduction to Garbage Collector [GC]
* Any code which works on Virtual Machines / engines it comes with GC; like JavaScript / Java / C# 
* We allocate memory; but don't explictly release them;
* GC is resposible for releasing memory

HEAP

* GC is a low priority thread
GC can be Short term GC {Scaveger} / Full term GC
Short term GC  is responsible to manage / clear un-referenced objects in Eden Area
If objects survive 3 rounds of Short-term GC --> objects need to be moved to old generation
*  long term GC runs for every 3 rounds of Short-term GC; it is responsible for Old Generation

Why we don't use pointers in Virtual Machines / engines?

=================

Exception Handling and JCF

Exception: any abnormal condition that arises during program execution

In java exception is an object whic tells:
1) What went wrong? [ ArithmeticExceptio ]
2) Why? [ / by zero ]
3) Where? [line ,method, class, ...]

Exception in thread "main" java.lang.ArithmeticException: / by zero
	at UncheckedExample.doTask(UncheckedExample.java:10)
	at UncheckedExample.main(UncheckedExample.java:4)

Error type of exceptions: error type of exceptions are one which can't be handled; fix the bug and re-run the application
Examples: OutOfMemoryError, StackOverflowError

Exception type of exceptions: can be handled, can have alternate flow
* Unchecked type of exceptions
    These checked exceptions occur due to issues with JRE;
    these exceptions are supposed to be handled with conditional statements
    Compiler doesn't enforce you to handle that

    Examples: ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException

```
    int data = 100;
        int no = 0;
        System.out.println(data / no); // ArithmeticException

    Solution:
    if(no != 0 ) {
        System.out.println(data / no); 
    }
    Product p = null;
    p.setPrice(3433); // NullPointerException

    Solution:
    if(p != null) {
        p.setPrice(3433); 
    }
    int[] data = {5,1,11};
    System.out.println(data[10]); // ArrayIndexOutOfBoundsException

    Solution:
    int index = 10;

    if(index >= 0 && index < data.length) {
        System.out.println(data[index]);
    }

```

* Checked Type of exception
these exceptions occur due to reasons outside of JRE; like database, OS, file, sockets, Threads, ...
Compiler enforces you to handle these type of exceptions
handling is done using try/catch/finally blocks

Examples: IOException, SocketException, SQLException, ClassNotFoundException, InterruptedException, ...

```
 private static void doTask() {
        System.out.println("doTask() called!!!");
        // a.txt can exist or not
        try {
            FileInputStream fis = new FileInputStream("a.txt");
            // other actions
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
```

Exceptions are pushed up the call stack.

```
main() --> a() --> b() --> c()
```

If exception occurs in c(); it can be handled in c(); if not handled it is propaged/pushed to b();
b() can delegate to a(); can be handled in a() or delegate to main();
if main() doesn't handle it hands it over to DefaultHandler provided for the thread.
If exception is handed over to the DefaultHandler; DefaultHandler prints the error and program terminates

===

In case of Checked type of exception; we need "throws" keyword to specify that exception is propagated up the call chain.

"throw" keyword --> pending

===============================================

Generic Types:

```
public class Rectangle {
    private double width;
    private double height;
}

Rectangle r1 = new Rectangle(4.5, 1.2);

public class IRectangle {
    private int width;
    private int height;
}

IRectangle r2 = new IRectangle(4 , 12);

Solution: 

public class Rectangle<T> {
    private T width;
    private T height;
}

now width and height are of type "T" generic

Rectangle<Double> r1 = new Rectangle<Double>( 4.1, 6.7);
Rectangle<Integer> r2 = new Rectangle<Integer>( 2, 7);
Rectangle<String> r3 = new Rectangle<String>( "A" , "B" );

Integer, Double are TypeWraper classes for int and double
Why?
Generics is not applicaple for primitive types, can be used only for Objects

int x = 10;
Integer iX = x; // Boxing, primitive --> object
...

int y = iX; // unboxing, object --> primitive

```

Compiler erases the type definitions of generics, code gets converted to:

```

public class Rectangle<T> {
    private T width;
    private T height;
}

to

public class Rectangle {
    private Object width;
    private Object height;
}

Example 2: Narrow the generic type

public class Rectangle<T extends Number> {
    private T width;
    private T height;
}


to

public class Rectangle {
    private Number width;
    private Number height;
}

Rectangle<Double> r1 = new Rectangle<Double>( 4.1, 6.7);
Rectangle<Integer> r2 = new Rectangle<Integer>( 2, 7);
Rectangle<String> r3 = new Rectangle<String>( "A" , "B" ); // error
```

Without Generic methods:

```

public interface IComparable {
    int compare(Object other);
}

public class Circle implements IComparable {
     @Override
    public int compare(Object other) {
        Circle c = (Circle) other;
        return this.radius - c.radius;
    }
}

public abstract class Product implements IComparable {
 @Override
    public int compare(Object other) {
        Product p = (Product) other;
        return (int) (this.price - p.price);
    }
}
```

Generic methods:

```
public interface IComparable<T> {
    int compare(T other);
}

public class Circle implements IComparable<Circle> {
    @Override
    public int compare(Circle other) {
        return this.radius - other.radius;
    }
}

public abstract class Product implements IComparable<Product> {
 @Override
    public int compare(Product other) {
        return (int) (this.price - other.price);
    }
}
```

Java Collection Framework
provides support for data containers / data structures to be used instead of arrays

* Limitations of array container is
1) size is fixed
 Product[] products = new Product[5];

2) can't grow / shrink

3) Adding / removing from arbitrary position is difficult

4) needs contiguos memory

JCF provides:
1) interfaces
2) implementation classes
3) Algorithm / utility classes

Arrays: utility class which contains alg like sort, max, min, binarySearch, ... which can be used for array type of container containing any type of data [string, number, product,..]
Arrays uses Comparable / Comparator for comparision

```
Use Comparable if the comparision logic is part of the object itself.
public interface Comparable<T> {
    public int compareTo(T o);
}

Terminal: ls
Logic to display is provided by the File system of OS

-rw-r--r--@ 1 banuprakash  staff  1063 Dec  9 12:29 Account.java
-rw-r--r--@ 1 banuprakash  staff   510 Dec 10 09:55 Circle.java
-rw-r--r--@ 1 banuprakash  staff  1046 Dec  9 14:18 Mobile.java
-rw-r--r--@ 1 banuprakash  staff  1365 Dec 10 09:56 Product.java
-rw-r--r--@ 1 banuprakash  staff   572 Dec  9 15:38 Tv.java

Use Comparator if the comparision logic is provided by the client application / code.

FileExplorer provided different ways of sorting --> comparision logic  is provided by FileExplorer
@FunctionalInterface
public interface Comparator<T> {
     int compare(T o1, T o2);
}
```


Collection can be:
1) List interface
* ordered collection
* can have duplicate elements
* can be re-ordered [ sort , shuffle, reverse, ..]
* can use index based operation [ add(obj, 3); remove(6); get(10), ...]
* can grow or shrink

Implementation classes:
a) ArrayList
b) LinkedList
c) Legacy : Vector and Stack : not supposed to be used [ issues in this]
d) 3rd party implementations like :VAVR, Apache Collections, ...
https://vavr.io/
https://commons.apache.org/proper/commons-collections/

ArrayList:
* like array it is contiguos memory
* can grow or shrink
* 99% of the time we use this

LinkedList:
* Doubly linked list
* doesn't need contiguos memory
* adding / removing from arbitrary position is more efficient
Cons:
* each node has 8 bytes extra memory occupied

Generally we load paginated results on to memory, so ArrayList which uses contiguos memory is OK to use.

Scenario 1:
// not recommended --> not typesafe
// ArrayList list = new ArrayList(); not advised, program to interface
List list = new ArrayList();
//List list = new LinkedList();
list.add(new Mobile(..));
list.add(new Date());
list.add("Hello");

we need to do type checking before we use

if(list.get(0) instanceof Mobile) {
    Mobile m = (Mobile) list.get(0);
}

Scenario 1: TypeSafe
List<Integer> list = new ArrayList<Integer>(); 
list.add(4);
list.add(12);
list.add("A"); // error

int x = list.get(0); // no need to do typechecking

2) Set
3) Queue


Collections are similar to Arrays utility class but can be used on List type of container instead of array.

=======

Java 8 introduced streams.
stream can be attached to collection / network / file system / database 
Once stream is attached we can use the following High Order Functions 
HOF: functions which accept functions as arguments; treat functions as first class member like primitive or object
Commonly used HOF:
* filter: to get subset based on predicate
filter(predicateFn)
* map: to transform the data
map(transformFn)
* forEach(actionFn)
* reduce(aggregateFn)

https://rxmarbles.com/

Terminal functions are :forEach, reduce, collect
Intermediary functions: filter, map, skip, limit, flatMap
we can use n number of Intermediary functions in the chain in any order

Note: data flows thro stream only if we have terminal function;

=============

Set
* unique collection
* index based operation is not supported
* re-order is not supported; can't sort/ shuffle / reverse
* order of elements is decided based on type of set implementation
Popular Set implementations:
1) HashSet
2) LinkedHashSet
3) TreeSet


Any hash based data containers uses hashCode() and equals() to identifying duplicates and ordering
equals() will be called only when hashcode collides

HashCode: Numerical value of an object
* Similar objects should have same hashCode
* objects which are not similar can also have same hashCode [ possibility]

Object class internally uses address of object as hashCode --> not correct;
equals works like == operator
So we need to override these methods

// Rarely used; avoid it; internally it's a RedBlack Tree
TreeSet uses Comparable / Comparator for identifying duplicates and ordering

instead we use a combination of HashSet and List for Ordering
```
  Set<Product> products = new HashSet<>();
  products.add(new Product(42, "LG AC", 45000.00, "ELEC"));
  products.add(new Product(89, "Sony Bravia", 245000.00, "TV"));

  // collections are inter-operable
  List<Product> prodList = new ArrayList<>(products); // valid
  Collections.sort(prodList);
```
       
Map container stores the data in the form of key/value pair like Dictionary
* HashMap
* TreeMap
* Hashtable [deprecated / old/ legacy/ same issues as Vector and Stack]

Key has to be unique, values can be duplicated.

Map produces Set of Keys and List of Values

===================

Arrays are Co-variant
Collections of JCF are not co-variant

```
Covariant simply means if X is subtype of Y then X[] will also be sub type of Y[]. Arrays are covariant As string is subtype of Object So

String[] is subtype of Object[]

Invariant simply means irrespective of X being subtype of Y or not ,

 List<X> will not be subType of List<Y>.

```



















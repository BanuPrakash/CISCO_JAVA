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













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

=======================================


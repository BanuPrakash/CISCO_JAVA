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
========




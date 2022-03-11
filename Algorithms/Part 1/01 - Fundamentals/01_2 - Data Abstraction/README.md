# Algorithms - Part 1

**TABLE OF CONTENTS**

1. [Fundamentals](#1)
    1. [Data Abstraction](#12)
        1. [Using abstract data types](#121)
        2. [Examples of abstract data types](#122)
        3. [Implementing abstract data types](#123)
        4. [More implementation of abstract data types](#124)
        5. [Designing abstract data types](#125)

<a name="1"></a>

## 1. Fundamentals

<a name="12"></a>

### Data Abstraction

Programming in Java is largely based on building data types. This is type of programming is known as object-oriented
programming, as it revolves around the concept of an object, an entity that holds a data type value. With Java's
primitive types we are largely confined to program that operate on numbers, but with reference types we can write
programs that operate on strings, pictures, sounds, or any of hundreds of other abstractions that are available in
Java's standard libraries. Even more significant than libraries of predefined data types is that the range of data types
available in Java programming is open-ended, because you can define your own data types.

- ***Data types*** A _data types_ is a set of values and a set od operations on those values.
- ***Abstract data types*** An _abstract data type_ is a data type whose internal representation is hidden from the
  client.
- ***Objects*** An _object_ is an entity that can take on a data-type value. Objects are characterized by three
  essential properties:
    - The *state* of an object is a value from its data type
    - The *identity* of an object distinguishes one object distinguishes one object from another
    - The *behavior* of an object is the effect of data-type operations.
- In Java, a *reference* is a mechanism for accessing an object.
- ***Applications programming interface(API)*** To specify the behavior of an abstract data type, we use an application
  programming interface (API), which is a list of _constructors_ and _instance methods_ (operations), with an informal
  description of the effect of each, as in this API for `Counter`:

<table style="height: 91px; width: 96.4489%; border-collapse: collapse; border-style: outset;" border="1">
<tbody>
<tr style="height: 19px;">
<td style="width: 87.5243%; height: 19px; border-style: hidden;" colspan="3"><code>public class <span style="color: #ff0000;">Counter</span></code></td>
</tr>
<tr style="height: 18px;">
<td style="width: 21.1178%; height: 18px; border-style: hidden;">&nbsp;</td>
<td style="width: 21.6067%; height: 18px; border-style: hidden;"><code>Counter(String id)</code></td>
<td style="width: 44.7998%; height: 18px; border-style: hidden;"><span style="color: #ff0000;"><em>create a counter named</em> <code>id</code></span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 21.1178%; height: 18px; text-align: right; border-style: hidden;"><code>void</code></td>
<td style="width: 21.6067%; height: 18px; border-style: hidden;"><code>increment()</code></td>
<td style="width: 44.7998%; height: 18px; border-style: hidden;"><em><span style="color: #ff0000;">increment the counter by one</span></em></td>
</tr>
<tr style="height: 18px;">
<td style="width: 21.1178%; height: 18px; text-align: right; border-style: hidden;"><code>int</code></td>
<td style="width: 21.6067%; height: 18px; border-style: hidden;"><code>tally()</code></td>
<td style="width: 44.7998%; height: 18px; border-style: hidden;"><em><span style="color: #ff0000;">number of increments since creation</span></em></td>
</tr>
<tr style="height: 18px;">
<td style="width: 21.1178%; height: 18px; text-align: right; border-style: hidden;"><code>String</code></td>
<td style="width: 21.6067%; height: 18px; border-style: hidden;"><code>toString()</code></td>
<td style="width: 44.7998%; height: 18px; border-style: hidden;"><em><span style="color: #ff0000;">string representation</span></em></td>
</tr>
</tbody>
</table>

- ***Client*** A client is a program that uses a data type.
- ***Implementation*** An implementation is the code that implements the data type specified in an API.
  <a name="121"></a>

#### Using abstract data types

***API for an abstract data type***

And ADT definition has many similarities with a library of static methods:

- Both are implemented as a Java class.
- Instance methods may take zero or more arguments of a specified type, separated by commas and enclosed in parentheses.
- They may provide a return value of a specified type or no return value (signified by void)

And there are three significant difference:

- Some entries in the API have the same name as the class and lack a return type. Such entries are known as constructors
  and play a special role. In this case, `Counter`has a constructor that takes a String argument.
- Instance methods lack the static modifier. They are not static methods -- their purpose is to operate on data type
  values.
- Some instance methods are present to adhere to Java conventions -- we refer to such methods as inherited methods and
  shade them gray in the API.

***Inherited methods***

All Java data types *inherit* a `toString()` method that typically returns a String representation of the data-type
values. Java calls this method when any data-type value is to concatenated with s `String`value with the + operator. The
default implementation is not particularly useful, so we often provide an implementation that overrides the default, and
include `toString()` in the API.

***Client code***

As with modular programming based on static methods, the API allows us to write client code without knowing details of
the implementation.

We can use an ADT in any program provided that the source code is in a `.java`file in the same directory, or in the
standard Java library, or accessible through a `import`statement.

By encapsulating all the code that implements a data type within a single Java class, we enable the development of
client code at a higher level of abstraction. To develop client code, you need to be able to declare variables, create
objects to hold datatype values, and provide access to the values for instance methods to operate on them. These
processes are different from the corresponding processes for primitive types.

***Objects***

An _object_ is an entity that can take on a data-type value. Objects are characterized by three essential properties:

- The *state* of an object is a value from its data type
- The *identity* of an object distinguishes one object distinguishes one object from another
- The *behavior* of an object is the effect of data-type operations.

***Creating objects***

Each data-type value is stored in an n object. To create (or instantiate) an individual object, we invoke a constructor
by using the keyword `new`.

A constructor has no return type because it always returns a reference to an object of its data type. Each time that a
client uses `new()`, the system

- Allocates memory space for the object
- Invokes the constructor to initialize its value
- Returns a reference to the object

````java
import edu.princeton.cs.algs4.Counter;

class CreatingObjects {
    public static void main(String[] args) {
        Counter heads = new Counter("heads");
    }
}
````

We can create any number of objects from the same class -- each object has its own identity and may or may not store the
same value as another object of the same type.

````java
import edu.princeton.cs.algs4.Counter;

class CreatingObjects {
    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
    }
}
````

In an abstract data type, details of the representation of the value are hidden from client code.

***Invoking instance methods***

The purpose of an instance method is to operate on datatype values, so the Java language includes a special mechanism to
invoke instance methods that emphasizes a connection to an object.

Instance methods have all the properties of static methods:

- arguments are passed by value
- method names can be overloaded
- they may have a return value
- they may cause side effects

Each invocation is associated with an object.

````java

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

class InvokingInstanceMethods {
    public static void main(String[] args) {
        Counter heads;                          // declaration
        heads = new Counter("heads");           // invoke a constructor (create an object)
        heads.increment();                      // invoke an instance method that changes the object's value

        Counter tails = new Counter("tails");   // invoke another constructor (create another object)
        heads.tally() - tails.tally();          // invoke an instance method that accesses the object's value

        StdOut.println(heads);                  // invoke heads.toString() - automatic type conversion
    }
}
````

The primary purpose of static methods is to implement functions; the primary purpose of non-static (instance) methods is
to implement data-type operations.

A static method call starts with a class ame (uppercase, by convention) and a non-static method call always starts with
an object name (lowercase, by convention).

***Using objects***

Declaration give us variable names for objects that we can use in code. To use a given data type, we:

- Declare variables of the tye, for use in referring to objects.
- Use the keyword `new` to invoke a constructor that creates objects of the type
- Use the object name to invoke instance methods, either as statements or within expressions.

```java
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

class Flips {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < n; i++) {
            if (StdRandom.bernoulli(0.5)) heads.increment();
            else tails.increment();
        }
        StdOut.println(heads);
        StdOut.println(tails);
        int delta = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(delta));
    }
}
```

***Assignment statements***

An assignment statement with a reference type creates a copy of the reference. The assignment statement does not create
a new object, just another reference to an existing object. This situation is know _aliasing_: both variables refer to
the same object.

Changing the state of an object impacts all code involving aliased referencing that object.

Aliasing is a common source of bugs in Java programs, as illustrated by the following example:

````java
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

class AssignmentStatements {
    public static void main(String[] args) {
        Counter c1 = new Counter("ones");
        c1.increment();
        Counter c2 = c1;
        c2.increment();
        StdOut.println(c1);
    }
}
````

The cod prints the string `2 ones`.

***Objects as arguments***

You can pass objects as arguments to methods. Java passes a copy of the argument value from the calling program to the
method. This arrangement is known as pass by value. If you pass a reference to an object of type `Counter`, Java passes
a copy of that reference. Thus, the method cannot change the original reference (make it point to a different `Counter`)
, but it can change the value of the object, for example by using the reference to call `increment()`.

***Objects as return values***

You can also use an object as a return value from a method. The method might return ab object passed to it as an
argument, or it might create an object and return a reference to it. This capability is important because Java methods
allow only one return value- using objects enables us to write code that, return multiple values.

```java
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

class FlipsMax {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int t = 0; t < T; t++) {
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();
        }
        if (heads.tally() == tails.tally())
            StdOut.println("Tie");
        else StdOut.println(max(heads, tails) + " wins");
    }

    private static Counter max(Counter x, Counter y) {
        if (x.tally() > y.tally())
            return x;
        else
            return y;
    }
}
```

***Arrays are objects***

You can pass objects as arguments to methods. Java passes a copy of the argument value from the calling program to the
method. This arrangement is known as pass by value. If you pass a reference to an object of type Counter, Java passes a
copy of that reference. Thus, the method cannot change the original reference (make it point to a different Counter),
but it can change the value of the object, for example by using the reference to call increment().

***Arrays of objects***

Array entries can be of any type. When we create an array of objects, we do so in two steps:

- create the array, using the bracket syntax for array constructors;
- create each object in the array, using a standard constructor for each.

```java
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

class Rolls {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int SIDES = 6;

        // initialize counters
        Counter[] rolls = new Counter[SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "s");
        }

        // flip dice
        for (int j = 0; j < n; j++) {
            int result = StdRandom.uniform(1, SIDES + 1);
            rolls[result].increment();
        }

        // print results
        for (int i = 1; i <= SIDES; i++) {
            StdOut.println(rolls[i]);
        }
    }
}
```

<a name="122"></a>

#### Examples of abstract data types

***Geometric objects***

***Information processing***

***Strings***

***Input and output revisited***

<a name="123"></a>

#### Implementing abstract data types

***Instance variables***

***Constructors***

***Instance methods***

***Scope***

***API, clients, and implementations***

<a name="124"></a>

#### More implementation of abstract data types

***Date***

***Maintaining multiple implementations***

***Accumulator***

***Visual accumulator***

<a name="125"></a>

#### Designing abstract data types

***Encapsulation***

***Designing APIs***

***Algorithms and abstract data types***

***Interface inheritance***

***Implementation inheritance***

***String conversion***

***Wrapper types***

***Equality***

***Memory management***

***Immutability***

***Design by contact***

***Exceptions and errors***

***Assertions***
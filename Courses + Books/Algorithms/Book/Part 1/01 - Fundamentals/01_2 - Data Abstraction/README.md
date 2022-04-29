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

A natural example of object-oriented programming is designing data types for geometric objects.

- Point2D.java is a data type for points in the plane.
- Interval1D.java is a data type for one-dimensional intervals
- Interval2D.java is a data type for two-dimensional intervals.

```java
import edu.princeton.cs.algs4.*;

class GeometricObjects {
    public static void main(String[] args) {
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);

        Interval1D xint = new Interval1D(xlo, xhi);
        Interval1D yint = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xint, yint);
        box.draw();

        Counter counter = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            Point2D point2D = new Point2D(x, y);
            if (box.contains(point2D))
                counter.increment();
            else
                point2D.draw();
        }

        StdOut.println(counter);
        StdOut.printf("area = %.2f\n", box.area());

    }
}
```

This computation is a model for a method that reduces the problem of computing the area and volume of geometric shapes
to the problem of determining whether a point falls within the shape or not.

***Information processing***

Abstract data types provide a natural mechanism for organizing the information.

- Date.java is a data type that represents the day, month, and year.
- Transaction.java is a data type that represents a customer, a date, and an amount.

The idea is to define data types that allow us to keep information in objects that correspond to things in the real
world.

Each data type consists of constructors that create objects containing the data and methods for use by client code to
access it.

The focus of such data types is on encapsulating the data, while at the same time enabling the development of client
code that does not depend on the representation of the data.

***Strings***

A String is an indexed sequence for char values. String has dozens of instance methods, including the following:

<table style="border-collapse: collapse; width: 100%; height: 217px;" border="1">
<tbody>
<tr style="height: 19px;">
<td style="width: 33.3333%; height: 19px;" colspan="3"><code>public class <span style="color: #ff0000;">String</span></code></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; height: 18px;">&nbsp;</td>
<td style="width: 33.3333%; height: 18px;"><code>String()</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><em>create an empty string</em></span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>int</code></td>
<td style="width: 33.3333%; height: 18px;"><code>length()</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><em>length of the string</em></span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>char</code></td>
<td style="width: 33.3333%; height: 18px;"><code>charAt(int i)</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><code>i</code><em>th character</em></span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>int</code></td>
<td style="width: 33.3333%; height: 18px;"><code>indexOf(String p)</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><em>first occurrence of</em> <code>p</code> (-1 <em>if none</em>)</span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>int</code></td>
<td style="width: 33.3333%; height: 18px;"><code>indexOf(String p, int i)</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><em>first occurrence of</em> <code>p</code> <em>after</em> <code>i</code> (-1 <em>if none</em>)</span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>String</code></td>
<td style="width: 33.3333%; height: 18px;"><code>concat(String t)</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><em>this string</em> <em>with</em> <code>t</code> <em>appended</em></span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>String</code></td>
<td style="width: 33.3333%; height: 18px;"><code>substring(int i, int j)</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><em>substring of this string</em> (<code>i</code><em>th to</em> <code>j-1</code><em>st chars</em></span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>String[]</code></td>
<td style="width: 33.3333%; height: 18px;"><code>split(String delim)</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><em>strings between occurrences of</em> <code>delim</code></span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>int</code></td>
<td style="width: 33.3333%; height: 18px;"><code>compareTo(String t)</code></td>
<td style="width: 33.3333%; height: 18px;"><em><span style="color: #ff0000;">string comparison</span></em></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>boolean</code></td>
<td style="width: 33.3333%; height: 18px;"><code>equals(String t)</code></td>
<td style="width: 33.3333%; height: 18px;"><span style="color: #ff0000;"><em>is this string's value the same as</em> <code>t</code><em>'s</em></span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: right; height: 18px;"><code>int</code></td>
<td style="width: 33.3333%; height: 18px;"><code>hashCode()</code></td>
<td style="width: 33.3333%; height: 18px;"><em><span style="color: #ff0000;">hash code</span></em></td>
</tr>
</tbody>
</table>

`String` values are similar to arrays of characters, but the two are not the same. Arrays have built-in Java language
syntax for accessing a character; `String`has instance methods for indexed access, length, and many other operations.

`String` has special language support for initialization and concatenation: instead of creating and initializing a
string with a constructor, we can use a string literal; instead of invoking the method `concat()` we can use the `+`
operator.

***Input and output revisited***

A disadvantage of the `StdIn`, `StdOut`, and `StdDraw` libraries is that they restrict us to working with just one input
file, one output file, and one drawing for any given program. With object-oriented programming, we can define similar
mechanisms that allow us to work with multiple input streams, output streams, and drawings within one program.
Specifically, our standard library includes the data types In.java, Out.java, and Draw.java that support multiple input
and output streams.

````java
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

class Cat {
    public static void main(String[] args) {
        // Copy input files to go out (last argument)
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length; i++) {
            // Copy input file names on ith arg to out
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }
}
````

<a name="123"></a>

#### Implementing abstract data types

We implement ADTs with a Java class, putting the code in a file with the same name as the class, followed by the .java
extension.

The first statements in the file declare _instance variables_ that define the data-type values.Following the instance
variables are the constructor and the instance methods that implement operations on data-type values.

In instance methods may be _public_ (specified in the API) or _private_ (used to organize the computation and not
available to clients).

***Instance variables***

To define data-type values (the state of each object), we declare instance variables in much the same way as we declare
local variables. There are numerous values corresponding to each instance variables (one for each object that is an
instance of the data type) Each declaration is qualified by _visibility modifier_. In ADT implementations, we
use `private`, using a Java language mechanism to enforce the idea that representation of an ADT is to be hidden from
the client, and also `final, if the value is not to be changed once it is initialized.

````java
public class Counter {
    // instance variable declarations
    private final String name;
    private int count;
}
````

***Constructors***

Every Java class has at easy one *constructor* that establishes an object's _identity_. A constructor is like a static
method, but it can refer directly to instance variables and has no return value. Generally, the purpose of a constructor
is to initialize the instance variables.Every constructor creates an object and provides to the client a reference to
that object.

Constructors always share the same name as the class. We can overload the name and have multiple constructors with
different signatures, just as with methods. If no other constructor is defined, a default no-argument constructor is
implicit, has no arguments, and initializes instance values to default values. The default values of instance variables
are 0 for primitive numeric types, `false` for `boolean`, and `null`.

***Instance methods***

Instance methods specify the data-type operations. Each instance method has a return type, a signature (which specifies
its name and the types and names of its parameter variables), and a _body_ (which consists of a sequence of statements,
including a _return_ statement that provides a value of the return type back to the client). When a client invokes a
method, the parameter values (if any) are initialized with client values, the statements are executed, until a return
value is computed, and the value is returned to the client. Instance methods may be _public_ (specified in the API) or
private (used to organize the computation and not available to clients).

````java

import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.algs4.StdOut;

public class Counter {   /*Counter is a Class name*/

    // instance variables
    private final String name;
    private int count;

    // constructor
    public Counter(String id)  /*Counter is a Class name*/ {
        /*
                public is visibility modifier.
                There is no return type.
                Counter is a constructor name (same as class name).
                String is a parameter variable.
                
                public Counter(String id) is a signature.
         */
        name = id; // name = id; is a code to initialize instance variables. (count initialized to 0 by default)

    }

    // instance methods
    public void increment() {
        /*
                public is visibility modifier.
                void is return type.
                increment() is a method name.
                
                public void increment() is a signature.
         */
        count++; // count is an instance variable name.
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return count + " " + name; /* name is an instance variable name */
    }

    // test client
    public static void main(String[] args) {
        // create and initialize objects
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails"); /* Counter("tails") is a invoke constructor */

        heads.increment();
        heads.increment();
        tails.increment();

        StdOut.println(heads + " " + tails); /* Automatically invoke toString */
        StdOut.println(heads.tally() - tails.tally()); /* tails is an object name, tally() is an invoke method */

    }
}
````

***Scope***

Instance methods use three kinds of variables: parameter variables, local variables, and instance variables. The first
two of these are the same as for static methods: parameter variables are specified in the method signature and
initialized with client values when the method is called, and local variables are declared and initialized within the
method body. The scope of parameter variables is the entire method; the scope of local variables is the following
statements in the block where they are defined. Instance variables hold data-type values for objects in a class, and
their scope is the entire class (whenever there is an ambiguity, you can use the `this` prefix to identify instance
variables).

````java
import edu.princeton.cs.algs4.StdOut;

public class Scope {
    private int var; //instance variable

    private void method1() {
        int var; // local variable

        StdOut.println(var);        //refers to a local variable, NOT instance variable
        StdOut.println(this.var);   // refers to  instance variable
    }

    private void method2() {
        StdOut.println(var);        // refers to instance variable
    }
}
````

***API, clients, and implementations***

Every ADT implementation that we will consider will be a Java class with private instance variables, constructors,
instance methods, and a client. To fully understand a data type, we need the API, typical code, and implementation.

We think about the these of a client, to accommodate them in an ADT, following these 3 steps:

- Specify an API. The purpose of the API is to _separate clients from implementations_, to enable modular programming.
  We have 2 goals when specifying an API.
    1. We want to enable clear and correct client code.
    2. We want to be able to implement the operations.
- Implement a Java class that meets the API specifications.
    1. We choose the instance variables.
    2. We write constructors and the instance methods.
- Develop multiple test clients, to validate the design decisions made in the first two steps.

**API**

<table style="border-collapse: collapse; width: 100%; height: 95px;" border="1">
<tbody>
<tr style="height: 19px;">
<td style="width: 6.96023%; height: 19px;">API</td>
<td style="width: 93.0398%; height: 19px;" colspan="3"><code>public class <span style="color: #ff0000;">Counter</span></code></td>
</tr>
<tr style="height: 19px;">
<td style="width: 6.96023%; height: 76px;" rowspan="4">&nbsp;</td>
<td style="width: 13.9205%; text-align: right; height: 19px;">&nbsp;</td>
<td style="width: 25.2841%; height: 19px;"><code>Counter (String id)</code></td>
<td style="width: 53.8352%; height: 19px;"><span style="color: #ff0000;"><em>create a counter named&nbsp;</em><code>id</code></span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 13.9205%; text-align: right; height: 19px;"><code>void</code></td>
<td style="width: 25.2841%; height: 19px;"><code>increment()</code></td>
<td style="width: 53.8352%; height: 19px;"><span style="color: #ff0000;"><em>increment the counter</em></span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 13.9205%; text-align: right; height: 19px;"><code>int</code></td>
<td style="width: 25.2841%; height: 19px;"><code>tally()</code></td>
<td style="width: 53.8352%; height: 19px;"><span style="color: #ff0000;"><em>number of increments since creation</em></span></td>
</tr>
<tr style="height: 19px;">
<td style="width: 13.9205%; text-align: right; height: 19px;"><code>String</code></td>
<td style="width: 25.2841%; height: 19px;"><code>toString()</code></td>
<td style="width: 53.8352%; height: 19px;"><span style="color: #ff0000;"><em>string representation</em></span></td>
</tr>
</tbody>
</table>

**Typical Client**

````java
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Flips {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);

        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int t = 0; t < T; t++) {
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();
        }
        StdOut.println(heads);
        StdOut.println(tails);
        int d = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(d));
    }
}
````

**Implementation**

````java
public class Counter {
    private final String name;
    private int count;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return "Counter{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
````

<a name="124"></a>

#### More implementation of abstract data types

***Maintaining multiple implementations***

* *First implementation*
    * ````java
      import edu.princeton.cs.algs4.StdOut;
    
      class Date {
    
          private final int month;
          private final int day;
          private final int year;
    
          public Date(int m, int d, int y) {
              month = m;
              day = d;
              year = y;
          }
    
          public int getMonth() {
              return month;
          }
    
          public int getDay() {
              return day;
          }
    
          public int getYear() {
              return year;
          }
    
          @Override
          public String toString() {
              return "Date{" +
                      "month=" + month +
                      ", day=" + day +
                      ", year=" + year +
                      '}';
          }
    
          public static void main(String[] args) {
              int m = Integer.parseInt(args[0]);
              int d = Integer.parseInt(args[1]);
              int y = Integer.parseInt(args[2]);
              Date date = new Date(m, d, y);
              StdOut.println(date);
          }
      }
      ````

* *Second implementation*
    * ```java
        class Date{
            private final  int value;
          
            public Date(int m, int d, int y){
                value = y * 512 + m * 32 + d;
            }
            public int month(){
                return (value / 32) % 16;
            }
            public int day(){ 
                return value % 32;
            }
          
            public int year() {
                return value / 512;
            }
  
            @Override
            public String toString() {
              return "Date{" +
                      "month=" + month() +
                      ", day=" + day() +
                      ", year=" + year() +
                      '}';
          }
  
            public static void main(String[] args) {
                int m = Integer.parseInt(args[0]);
                int d = Integer.parseInt(args[1]);
                int y = Integer.parseInt(args[2]);
                Date date = new Date(m, d, y);
                StdOut.println(date);
            }
        }
    ```

***Accumulator***

````java
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Mean (" + N + " values): "
                + String.format("%7.5f", mean());
    }
}

public class TestAccumulator {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Accumulator accumulator = new Accumulator();
        for (int t = 0; t < T; t++) {
            accumulator.addDataValue(StdRandom.random());
        }
        StdOut.println(accumulator);
    }
}
````

***Visual accumulator***

```java
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

class TestVisualAccumulator {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int t = 0; t < T; t++)
            a.addDataValue(StdRandom.random());
        StdOut.println(a);
    }
}

public class VisualAccumulator {
    private double total;
    private int N;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, mean());
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Mean (" + N + " values): "
                + String.format("%7.5f", mean());
    }
}
```

<a name="125"></a>

#### Designing abstract data types

An abstract data type is a data type whose representation is hidden from the client.

Our goal is to put important information related to designing data types in one place for reference and to set the stage
for implementations.

***Encapsulation***

A hallmark of object-oriented programming is that it enables us to encapsulate data types within their implementations,
to facilitate separate development of clients and data type implementations. Encapsulation enables modular programming,
allowing us to

- Independently develop client and implementation code
- Substitute improved implementations without affecting clients
- Support programs not yet written (the API is a guide for any future client)

Encapsulation also isolates data-type operations, which leads to the possibility of

- Limiting the potential for error
- Adding consistency checks and other debugging tools in implementations
- Clarifying client code

An encapsulated data type can be used by any client, so it extends the Java language.

_You do not need to know how a data_ type is implemented in order to use it, and _you can assume that a client knows
nothing but the API_ when implementing a data type. Encapsulation is the key to attaining both of these advantages.

***Designing APIs***

One of the most important and most challenging steps in building modern software is designing APIs.

Articulating an API might seem to be overkill when writing a small program, but you should consider writing every
program as though you will need to reuse the code someday.Ideally, an API would clearly articulate behavior for all
possible inputs, including side effects, and then we would have software to check that implementations meet the
specification. Unfortunately, a fundamental result from theoretical computer science known as the specification problem
implies that this goal is actually impossible to achieve.

There are numerous potential pitfalls when designing an API:

* An API may be too hard to implement, implying implementations that are difficult or impossible to develop.
* An API may be too hard to use, leading to client code that is more complicated than it would be without the API.
* An API may be too narrow, omitting methods that clients need.
* An API may be too wide, including a large number of methods not needed by any client. This pitfall is perhaps the most
  common, and one of the most difficult to avoid. The size of an API tends to grow over time because it is not difficult
  to add methods to an existing API, but it is difficult to remove methods without breaking existing clients.
* An API may be too general, providing no useful abstractions.
* An API may be too specific, providing abstractions so detailed or so diffuse as to be useless.
* An API may be too dependent on a particular representation, therefore not serving the purpose of freeing client code
  from the details of using that representation. This pitfall is also difficult to avoid, because the representation is
  certainly central to the development of the implementation.

These considerations are sometimes summarized in yet another motto: provide to clients the methods they need and no
others.

***Algorithms and abstract data types***

Data abstraction is naturally suited to the study of algorithms, because it helps us provide a framework within which we
can precisely specify both what an algorithm needs to accomplish and how a client can make use of an algorithm.

Data abstraction enables us to:

- Precisely specify what algorithms can provide for clients
- Separate algorithms implementations from the client code
- Develop layers of abstraction, where we make use of well-understood algorithms to develop other algorithms

````java
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StaticSETofInts;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Whitelist {
    public static void main(String[] args) {
        int[] w = In.readInts(args[0]);
        StaticSETofInts seTofInts = new StaticSETofInts(w);
        while (!StdIn.isEmpty()) {
            // Read key, print if not in whitelist
            int key = StdIn.readInt();
            if (!seTofInts.contains(key)) {
                StdOut.println(key);
            }
        }
    }
}

public class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i]; // defensive copy
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        // Binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
````

***Interface inheritance***

Java provides language support for defining relationships among objects, know as inheritance.

The first inheritance mechanism that we consider is known as subtyping , which allows us to specify a relationship
between otherwise unrelated classes by specifying in an interface a set of common methods that each implementing class
must contain.

An implementing class inherits the interface. Interface inheritance allows us to write client programs that can
manipulate objects of any type that implements the interface (even a type to be created in the future), by invoking
methods in the interface.

***Implementation inheritance***

Java also supports another inheritence mechanism known as subclassing, which is a powerful technique that enables a
programmer to change behavior and add functionality without rewriting an entire class from scratch. The idea is to
define a new class(subclass , or derived class) that inherits instance methods and instance variables from another
class(superclass , or base class). The subclass contains more methods than the superclass. The subclass can redefine or
override methods in the superclass.

Subclassing is widely used by systems programmers to build so-called extensible libraries

***String conversion***

Every Java type inherits `toString()`
from Object , so any client can invoke `toString()`
for any object. This convention is the basis for Java’s automatic conversion of one operand of the concatenation
operator + to a String whenever the other operand is a String .

***Wrapper types***

Java supplies built-in reference types known as wrapper types , one for each of the primitive types:
`Boolean` , `Byte` , `Character` , `Double` , `Float` , `Integer` , `Long` , and `Short` correspond to `boolean`
, `byte` , `char` , `double` ,
`float` , `int` , `long` , and `short` , respectively. These classes consist primarily of static methods such as
`parseInt()`
but they also include the inherited instance methods `toString()`
, `compareTo()`
, `equals()`
, and `hashCode()`
.

When an int value is concatenated with a `String` , it is converted to an Integer that can invoke `toString()`.

***Equality***

If we test equality with
(a == b)
where a and b are reference variables of the same type, we are testing whether they have the same identity: whether the
references are equal.

````java
public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Date that = (Date) x;
        if (this.day != that.day)
            return false;
        if (this.month != that.month)
            return false;
        return this.year == that.year;
    }
}
````

***Memory management***

The ability to assign a new value to a reference variable creates the possibility that a program may have created an
object that can no longer be referenced.

Objects are also orphaned when they go out of scope. Java programs tend to create huge numbers of objects (and variables
that hold primitive data-type values), but only have a need for a small number of them at any given point in time.

Memory management turns out to be easier for primitive types because all the information needed for memory allocation is
known at compile time.

Memory management for objects is more complicated: the system can allocate memory for an object when it is created, but
cannot know precisely when to free the memory associated with each object because the dynamics of a program in execution
determines when objects are orphaned.

One of Java's most significant features is its ability to automatically manage memory.

***Immutability***

An immutable data type, such as `Date`, has the property that the value of an object never changes once constructed.

The purpose of the abstraction is to encapsulate values that do not change so that we can use them in assignment
statements and as arguments and return values from functions in the same way we use primitive types (without having to
worry about their values changing).

`String` objects are immutable because we generally do not want `String` values to change, and Java arrays are mutable
because we generally do want arrays values to change.

Generally, immutable types are easier to use and harder to misuse than mutable types because the scope of code that can
change their values is far smaller. It is easier to debug code that uses immutable types because it is easier to
guarantee that variables in client code that uses them remain in a consistent state. When using mutable types, you must
always be concerned about where and when their values change.

If the type of data used for a binary search algorithm were mutable, then clients could invalidate our assumption that
the array is sorted for binary search.

***Design by contact***

We use two Java languages mechanism for this purpose:

- Exceptions and errors, which generally handle unforeseen errors outside our control
- Assertions, which verify assumptions that we make within code we develop

***Exceptions and errors***

Exceptions and errors are disruptive events that occur while a program is running, often to signal an error. The action
taken is known as throwing an exception or throwing an error.

A general practice known as fail fast programming suggests that an error is more easily pinpointed if an exception is
thrown as soon as an error is discovered.

***Assertions***

An assertion is a boolean expression that you are affirming is true at that point in the program.

We use assertions both to gain confidence in the correctness of programs and to document intent.

If this value were negative, it would cause an ArrayIndexOutOfBoundsException sometime later.

````
assert index >= 0 : "Negative index in method X";
````

Assertions are for debugging: your program should not rely on assertions for normal operation since they may be
disabled.

## Resources

- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
- [Algorithms, Part 1 - Coursera](https://www.coursera.org/learn/algorithms-part1)
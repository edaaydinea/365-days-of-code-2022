# Algorithms - Part 1

**TABLE OF CONTENTS**

1. [Fundamentals](#1)
    1. [Programming Model](#11)
        1. [Primitive data types and expressions](#111)
        2. [Statements](#112)
        3. [Arrays](#113)
        4. [Static Methods](#114)
        5. [APIs](#115)
        6. [Strings](#116)
        7. [Binary Search](#117)

<a name="1"></a>

## 1. Fundamentals

Rather than the computer itself, it is the method that specifies the steps that we can take to solve the problem. The
term *algorithm* is used in computer science to describe a finite, deterministic, and effective problem-solving method
suitable for implementation as a computer program.

We can define, an algorithm by describing a procedure for solving a problem in natural language, or by writing a
computer program that implements the procedure.

````java
/*
Compute the greatest common divisor of two nonnegative integers p and q as follows:
	- If q is 0, the answer is p.
	- If not, divide p by q and take the remainder r.
	- The answer is the greatest common divisor of q and r.
*/
public class GreatestCommonDivisor {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}

````

One important reason for doing so is that it makes easier the task of checking whether they are finite, deterministic,
and effective, as required.

Most algorithms of interest involve organizing the data involved in the computation.

Simple algorithms can give rise to complicated data structures and, conversely, complicated algorithms can use simple
data structures.

The primary reason to learn about algorithms is that this discipline gives us the potential to reap huge savings, even
to the point of enabling us to do tasks that would otherwise be impossible.

Careful algorithm design is an extremely effective part of the process of solving a huge problem, whatever the
applications area.

When developing a huge or complex computer program, a great deal of effort must go into understanding and defining the
problem to be solved, managing its complexity, and decomposing it into smaller subtasks that can be implemented easily.

Implementing simple versions of basic algorithms helps us to understand them better, and thus to more effectively use
and tune advanced versions from a library. More importantly, the opportunity to reimplement basic algorithms arises
frequently.

Choosing the best algorithm for a particular task can be a complicated process, perhaps involving sophisticated
mathematical analysis. The branch of computer science that comprises the study of such questions is called the *analysis
of algorithms*.

<a name="11"></a>

### 1.1 Programming Model

Our study of Algorithms is based upon implementing them as programs written in the Java programming language. We do so
for several reasons:

- Our programs are concise, elegant, and complete descriptions of algorithms.
- You can run the programs to study the properties of the algorithms.
- You can put the algorithms immediately to good use in applications.

<a name="111"></a>

#### Primitive data types and expressions.

A data type is a set of values and a set of operations on those values. The following four primitive data types are the
basis of the Java language:

- *Integers*, with arithmetic operations (int)
- *Real numbers*, again with arithmetic operations (double)
- *Booleans*, the set of values {true, false} with logical operations (booelean)
- *Characters*, the alphanumeric characters and symbols that you type (char)

A Java program manipulates variables that are named with identifiers. Each variable is associated with a data type and
stores one of the permissible data-type values. We use expressions to apply the operations associated with each type.

<table style="border-collapse: collapse; width: 100%; height: 270px;" border="1">
<tbody>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: center; height: 18px;"><strong>term</strong></td>
<td style="width: 16.6667%; text-align: center; height: 18px;" colspan="2"><strong>examples</strong><br /><strong><br /></strong></td>
<td style="width: 33.3333%; text-align: center; height: 18px;"><strong>definition</strong></td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: center; height: 18px;">primitive data type</td>
<td style="width: 16.6667%; text-align: center; height: 18px;" colspan="2">int double boolean char</td>
<td style="width: 33.3333%; text-align: center; height: 18px;">a set of values and a set of operations on those values (built in the Java language)</td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: center; height: 18px;">identifier</td>
<td style="width: 16.6667%; text-align: center; height: 18px;" colspan="2">a abc Ab$ a_b ab123 lo hi</td>
<td style="width: 33.3333%; text-align: center; height: 18px;">a sequence of letters, digits, _, and $, the first of which is not digit</td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: center; height: 18px;">variable</td>
<td style="width: 16.6667%; text-align: center; height: 18px;" colspan="2">[any identifier]</td>
<td style="width: 33.3333%; text-align: center; height: 18px;">names a data type value</td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: center; height: 18px;">operator</td>
<td style="width: 16.6667%; text-align: center; height: 18px;" colspan="2">+ - * /</td>
<td style="width: 33.3333%; text-align: center; height: 18px;">names a data-type operation</td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: center; height: 108px;" rowspan="4">literal</td>
<td style="width: 16.6667%; text-align: center; height: 18px;">int</td>
<td style="width: 16.6667%; text-align: center; height: 18px;">1 0 -42</td>
<td style="width: 33.3333%; text-align: center; height: 108px;" rowspan="4">source-code representation of a value</td>
</tr>
<tr style="height: 36px;">
<td style="width: 16.6667%; text-align: center; height: 36px;">double</td>
<td style="width: 16.6667%; text-align: center; height: 36px;">2.0 1.0e-15 3.14</td>
</tr>
<tr style="height: 18px;">
<td style="width: 16.6667%; text-align: center; height: 18px;">boolean</td>
<td style="width: 16.6667%; text-align: center; height: 18px;">true false</td>
</tr>
<tr style="height: 36px;">
<td style="width: 16.6667%; text-align: center; height: 36px;">char</td>
<td style="width: 16.6667%; text-align: center; height: 36px;">"a" "+" "9" "\n"</td>
</tr>
<tr style="height: 18px;">
<td style="width: 33.3333%; text-align: center; height: 72px;" rowspan="3">expression</td>
<td style="width: 16.6667%; text-align: center; height: 18px;">int</td>
<td style="width: 16.6667%; text-align: center; height: 18px;">lo + (hi-lo)/2</td>
<td style="width: 33.3333%; text-align: center; height: 72px;" rowspan="3">a literal, a variable, or a sequence of operations on literals and/or variables that produce a value</td>
</tr>
<tr style="height: 18px;">
<td style="width: 16.6667%; text-align: center; height: 18px;">double</td>
<td style="width: 16.6667%; text-align: center; height: 18px;">1.0e-15 * t</td>
</tr>
<tr style="height: 18px;">
<td style="width: 16.6667%; text-align: center; height: 18px;">boolean</td>
<td style="width: 16.6667%; text-align: center; height: 18px;">lo &lt;= hi</td>
</tr>
</tbody>
</table>

- ***Expressions*** Typical expressions are *infix*. When an expression contains more than one operator, the precedence
  order specifies the order in which they are applied: The operators `*` and `/` (and `%`) have higher precedence than (
  are applied before) the + and - operators; among logical operators, `!` is the highest precedence, followed by `&&`
  and then `||`. Generally, operators of the same precedence are *left associative* (applied left to right). You can use
  parentheses to override these rules.
- ***Type conversion*** Numbers are automatically promoted to a more inclusive type if no information is lost. For
  example, in the expression `1 + 2.5`, the 1 is promoted to the double value `1.0` and the expression evaluates to the
  double value `3.5`. A cast is a directive to convert a value of one type into a value of another type. For
  example (`int`) `3.7` is `3`. Casting a double to an int truncates toward zero.
- ***Comparisons*** The following mixed-type operators compare two values of the same type and produce a boolean value:
    - equal(`==`)
    - not equal (`!=`)
    - less than (`<`)
    - less than or equal (`<=`)
    - greater than (`>`)
    - greater than or equal (`>=`)
- ***Other primitive types***. Java's int has a 32-bit representation; Java's double type has a 64-bit representation.
  Java has five additional primitive data types:
    - 64-bit integers, with arithmetic operations (`long`)
    - 16-bit integers, with arithmetic operations (`short`)
    - 16-bit characters, with arithmetic operations (`char`)
    - 8-bit integers, with arithmetic operations (`byte`)
    - 32-bit single-precision real numbers, with arithmetic operations (`float`)

<a name="112"></a>

#### Statements

A Java program is composed of statements, which define the computation by creating and manipulating variables, assigning
data-type values to them, and controlling the flow of execution of such operations.

- ***Declarations*** create variables of a specified type and name them with identifiers. Java is a strongly typed
  language because the Java compiler checks for consistency. The scope of a variable is the part of the program where it
  is defined.
- ***Assignments*** associate a data-type value (defined by an expression) with a variable.
- ***Initializing declarations*** combine a declaration with an assignment to initialize a variable at the same time it
  is declared.
- ***Implicit assignments***. The following shortcuts are available when our purpose is to modify a variable's value
  relative to the current value:
    - Increment/decrement operators: the code `i++` is shorthand for `i = i + 1` . The code `++i` is the same except
      that the expression value is taken after the increment / decrement, not before.
- ***Conditional*** provide for a simple change in the flow of execution - execute the statements in one of two blocks,
  depending on a specified condition.
- ***Loops*** provide for a more profound change in the flow of execution - execute the statements in a block as long as
  a given condition is true. We refer to the statements in the block in a loop as the body of the loop.
- ***Break and continue***. Java supports two additional statements for use within while loops:
    - The`break`statement, which immediately exits the loop.
    - The `continue` statement, which immediately begins the next iteration of the loop
- ***For notation***. Many loops follow this scheme: initialize an index variable to some value and then use a `while`
  loop to test a loop continuation condition involving the index variable, where the last statement in the `while` loop
  increments the index variable. You can express such loops compactly with Java's `for` notation.
- ***Single-statement blocks***. If a block of statements in a conditional or a loop has only a single statement, the
  curly braces may be omitted.

The following table illustrates different kind of Java statements.

<table style="border-collapse: collapse; width: 100%; height: 484px;" border="1">
<tbody>
<tr style="height: 18px;">
<td style="width: 24.7453%; text-align: center; height: 18px;"><strong>statement</strong></td>
<td style="width: 41.9213%; text-align: center; height: 18px;"><strong>examples</strong></td>
<td style="width: 33.3333%; text-align: center; height: 18px;"><strong>definition</strong></td>
</tr>
<tr style="height: 78px;">
<td style="width: 24.7453%; text-align: center; height: 78px;"><span style="color: #ff0000;"><em>declaration</em></span></td>
<td style="width: 41.9213%; text-align: left; height: 78px;">
<p><code>int i;</code></p>
<p><code>double c;</code></p>
</td>
<td style="width: 33.3333%; text-align: center; height: 78px;">create a variable of a specified type, named with a given identifier</td>
</tr>
<tr style="height: 78px;">
<td style="width: 24.7453%; text-align: center; height: 78px;"><em><span style="color: #ff0000;">assignment</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 78px;">
<p><code>a = b + 3;</code></p>
<p><code>discriminant = b*b - 4.0*c;</code></p>
</td>
<td style="width: 33.3333%; text-align: center; height: 78px;">assign a data-type value to a variable</td>
</tr>
<tr style="height: 78px;">
<td style="width: 24.7453%; text-align: center; height: 78px;"><em><span style="color: #ff0000;">initializing declaration</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 78px;">
<p><code>int i = 1;</code></p>
<p><code>double c = 3.141592625;</code></p>
</td>
<td style="width: 33.3333%; text-align: center; height: 78px;">declaration that also assigns an initial value</td>
</tr>
<tr style="height: 78px;">
<td style="width: 24.7453%; text-align: center; height: 78px;"><em><span style="color: #ff0000;">implicit assignment</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 78px;">
<p><code>i++;</code></p>
<p><code>i += 1;</code></p>
</td>
<td style="width: 33.3333%; text-align: center; height: 78px;">i = i +1;</td>
</tr>
<tr style="height: 64px;">
<td style="width: 24.7453%; text-align: center; height: 64px;"><em><span style="color: #ff0000;">conditional (if)</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 64px;"><code>if (x &lt; 0) x = -x;</code></td>
<td style="width: 33.3333%; text-align: center; height: 64px;">
<p>execute a statement, depending on boolean expression</p>
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 24.7453%; text-align: center; height: 18px;"><em><span style="color: #ff0000;">conditional (if - else)</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 18px;">
<p><code>if (x &gt; y)&nbsp; max = x;</code><br /><code>else&nbsp; &nbsp; &nbsp; &nbsp; max = y ;</code></p>
</td>
<td style="width: 33.3333%; text-align: center; height: 18px;">execute one or the other statement, depending on boolean expression</td>
</tr>
<tr style="height: 18px;">
<td style="width: 24.7453%; text-align: center; height: 18px;"><em><span style="color: #ff0000;">loop (while)</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 18px;">
<p><code>int v = 0;</code><br /><code>while (v &lt;= N)</code><br /><code>&nbsp; &nbsp;v= 2 * v;<br />double t = c;<br />while (Math.abs(t - c/t) &gt; 1e-15t)<br />&nbsp; &nbsp; t = (c/t + t) / 2.0;</code></p>
</td>
<td style="width: 33.3333%; text-align: center; height: 18px;">execute statement until boolean expression is false</td>
</tr>
<tr style="height: 18px;">
<td style="width: 24.7453%; text-align: center; height: 18px;"><em><span style="color: #ff0000;">loop (for)</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 18px;"><code>for (int i = 0; i &lt;= N; i++)<br />&nbsp; &nbsp; sum&nbsp; += 1.0 / i;<br />for (int i = 0; i &lt;= N; i++)<br />&nbsp; &nbsp; StdOut.println(2*Math.PI*i/N);</code></td>
<td style="width: 33.3333%; text-align: center; height: 18px;">compact version of while statement</td>
</tr>
<tr style="height: 18px;">
<td style="width: 24.7453%; text-align: center; height: 18px;"><em><span style="color: #ff0000;">call</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 18px;"><code>int key = StdIn.readInt();</code></td>
<td style="width: 33.3333%; text-align: center; height: 18px;">invoke other methods</td>
</tr>
<tr style="height: 18px;">
<td style="width: 24.7453%; text-align: center; height: 18px;"><em><span style="color: #ff0000;">return</span></em></td>
<td style="width: 41.9213%; text-align: left; height: 18px;"><code>return false;</code></td>
<td style="width: 33.3333%; text-align: center; height: 18px;">return from a method</td>
</tr>
</tbody>
</table>

<a name="113"></a>

#### Arrays

An *array* stores a sequence of value that are all of the same type.If we have `N` values, we can use the
notation `a[i]`to refer to the ith value for any value of `i`from `0` to `N-1`.

- ***Creating and initializing an array*** Making an array in a Java program involves three distinct steps:
    - Declare the array name and type
    - Create the array
    - Initialize the array values
- ***Default array initialization*** For economy code, we often take advantage of Java's default array initialization
  convention and combine all three steps into a single statement. The default initial value is zero for numeric types
  and `false` for type `boolean`.
- ***Initializing declaration*** We can specify the initialization values at compile time, by listing literal values
  between curly braces, separated by commas.

```java

public class Arrays {

    public static void main(String[] args) {
        //Long Form
        double[] a;                 // declare an array by specifying all elements as double
        a = new double[N];          // create an array as length of N
        for (int i = 0; i < N; i++)
            a[i] = 0.0;             // initialize ith element of an array as 0.0

        // Short Form

        double[] a = new double[N]; //declare all elements as doubles and create an array of length n and the array

        // Initializing declaration
        int[] a = {1, 1, 2, 3, 5, 8};
    }

}
```

- ***Using an array*** Once we create an array, its size is fixed. A program can refer to the length of an array `a[i]`
  with the code `a.length`. Java does _automatic bounds checking_ - if you access an array with an illegal index your
  program will terminate with
  and [ArrayIndexOutOfBoundsException](http://download.oracle.com/javase/6/docs/api/java/lang/ArrayIndexOutOfBoundsException.html)
- ***Aliasing*** An array name refers to the whole array - if we assign one array name to another, then both refer to
  the same array.

```java
public class Arrays2 {
    public static void main(String[] args) {
        int[] a = new int[N];   // declare and create an array as N dimension
        a[i] = 1234;            // initialize ith element of array as 1234
        int[] b = a;            // copy the array a to array b
        b[i] = 5678;            // change the ith element of b | a[i] is now 5678.
    }
}

```

This situation is known as _**aliasing**_ and can lead to subtle bugs.

- ***Two-dimensional arrays***. A two-dimensional array in Java is an array of one-dimensional arrays. A two-dimensional
  array may be _ragged_ (its arrays may all be of differing lengths), but we most often work with (for appropriate
  parameters M and N) M-by-N two-dimensional arrays. To refer to the entry in row `i` and column `j` of a
  two-dimensional array `a[][]`, we use the notation `a[i][j]`.

<a name="114"></a>

#### Static methods

Static methods are called _functions_ in many programming languages, since they can behave like mathematical functions.
Each static method is a sequence of statements that are executed, one after the other, when the static method is _
called_.

- ***Defining a static method*** A method encapsulates a computation that is defined as a sequence of statements. A
  method takes arguments (values of given data types) and computes a _return value_ of some data type or causes a _side
  effect_. Each static method is composed of a _signature_ and a _body_.

````java
class StaticMethods {
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;             //local variables

    }
}

````

- ***Invoking a static method*** A call on a static method is its name followed by expressions that specify argument
  values in parentheses, separated by commas. When a method is called, its argument variables are initialized with the
  values of the corresponding expressions in the call. A `return` statement terminates a static method, returning
  control to the caller. If the static method is to compute a value, that value must be specified in a `return`
  statement.


- ***Properties of methods*** Java methods have the following features:
    - ***Arguments are passed by value***  When calling a function, the argument value is fully evaluated and the
      resulting value is *copied* argument variable. This is known as *pass* by value. Array (and other object)
      references are also passed by value: the method cannot change the reference, but it can change the entries in the
      array (or value of the object).
    - ***Method names can be overloaded** Methods within a class can have the same name, provided they have different
      signatures. This features is known as overloading.
    - ***A method has a single return value but may have multiple return statements***. A Java method can provide only
      one return value. Control goes back to the calling program as soon as the first `return` statement is reached.
    - ***A method can have side effects***. A method may use the keyword `void` as its return type, to indicate that it
      has no return value and produces side effects (consume input, produce output, change entries in an array, or
      otherwise change the state of the system).


- ***Recursion*** A recursive method is a method that calls itself either directly or indirectly. There are three
  important rules of thumb in developing recursive programs:
    - The recursion has a base case.
    - Recursive calls must address sub-problems that are *smaller* in some sense,so that recursive calls converge to the
      base case. -Recursive calls should not address sub-problems that *overlap*.

```java
class RecursiveBinarySearch {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int low, int high) {
        // Index of key in a[], if present, is not smaller than low and not longer than high
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (key < a[mid])
            return rank(key, a, low, mid - 1);
        else if (key > a[mid])
            return rank(key, a, mid + 1, high);
        else
            return mid;
    }
}

```

- ***Basic programming model***. A *library of static methods* is a set of static methods that are defined in a Java
  class. A basic model for Java programming is to develop a program that addresses a specific computational task by
  creating a library of static methods, one of which is named `main()`.


- ***Modular programming***. Libraries of static methods enable *modular programming*, where static methods in one
  library can call static methods defined in other libraries. This approach has many important advantages.
    - Work with modules of reasonable size
    - Share and reuse code without having to reimplement it.
    - Substitute improved implementations
    - Develop appropriate abstract models for addressing programming problems
    - Localize debugging


- ***Unit testing*** A best practice in Java programming is to include `main()` in every library of static methods that
  tests the methods in the library.


- ***External libraries*** We use static methods from three different kinds of libraries, each requiring (slightly)
  differing procedures for code reuse.
    - Standard system libraries in `java.lang`, including `java.lang.Math`, `java.lang.Integer`, and `java.lang.Double`.
      These libraries are available in Java.
    - Imported system libraries such as `java.util.Arays`. An `import` statement at the beginning of the program is
      needed to use such libraries.

<a name="115"></a>

#### APIS

A critical component of modular programming is documentation that explains the operation of library methods that are
intended for use by others.

Applications programming interfaces (APIs) that lists the library name and the signatures and short descriptions of each
of the methods that we use.

The purpose of an API is to seperate the client from the implementation: the client should know anothing about the
implementation other that information given in the API, and the implementation should not take properties of any
particular client into account.
<a name="116"></a>

#### Strings

***Concatenation***

````java
class Concatenation {
    public static void main(String[] args) {
        String name = args[0];
        String surname = args[1];

        System.out.println("Welcome " + name + " " + surname + "!");
    }
}
````

***Conversion***

Two primary uses of strings are to convert values that we can enter on a keyboard into data-type values and to convert
data-type values to values that we can read on display.

```java
import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the telephone number:");
        int telephone_number = scanner.nextInt();
        System.out.print(telephone_number.toString());

        // Other version
        System.out.print("Enter the second telephone number:");
        String telephone_number2 = scanner.next();
        System.out.print(parseInt(telephone_number2));
    }
}
```

***Automatic Conversion***

```java
class AutomaticConversion {
    public static void main(String[] args) {
        System.out.println("The square root of 2.0 is " + Math.sqrt(2.0));
    }
}

```

<a name="117"></a>

#### Binary Search

````java
import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {   // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {   // Key is in a[lo ..hi] or not present.
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

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!In.readInts.isEmpty()) {   // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                System.out.println(key);
        }

    }
}
````

This static method `rank()` takes an integer key and a sorted array of `int` values as arguments and returns the index
of the key if it is present in the array, -1 otherwise. It accomplishes this task by maintaining variables `lo`and `hi`
such that the key is in `a[lo..hi]` if it is in the array, then entering into a loop that tests the middle entry in the
interval (at index mid). If the key is equal to `a[mid]`, the return value is mid; otherwise the method cuts the
interval size about in half, looking at the left half if the key is less than `a[mid]` and at the right half if the key
is greater than `a[mid]`. The process terminates when the key is found or the interval is empty.

## Resources

- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
- [Algorithms, Part 1 - Coursera](https://www.coursera.org/learn/algorithms-part1)

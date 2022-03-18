# Algorithms - Part 1

**TABLE OF CONTENTS**

1. [Fundamentals](#1)
    1. [Bags, Queues, and Stacks](#12)
        1. [APIS](#121)
        2. [Implementing collections](#122)
        3. [Linked Lists](#123)

<a name="1"></a>

## 1. Fundamentals

<a name="12"></a>

### Bags, Queues, and Stacks

Several fundamental data types involve collections of objects. Specifically, the set of values is a collection of
objects, and the operations revolve around adding, removing, or examining objects in the collection.

Bags, queues, and stacks are fundamental and broadly useful.

Goal of this section:

1. To emphasize the idea that the way in which we represent the objects in the collection directly impact the efficiency
   of the various operations.
2. To introduce generics and iteration, basic Java constructs that substantially simplify client code.
    1. To introduce and show the importance of linked data structures. In particular, a classic data structure known as
       the linked list enables implementation of bags, queues and stacks that achieve efficiencies not otherwise
       possible.

```Understanding linked lists is a key first step to the study of algorithms and data structures.```

<a name="121"></a>

#### APIs

Each contains a no-argument constructor, a method to add an item to the collection, a method to test whether the
collection is empty, and a method that returns the size of the collection.

***Generics***

A specific Java mechanism known as generics, also known as parameterized types, enables this capability. The impact of
generics on the programming language is sufficiently deep that they are not found in many languages.

The notation`<Item>` after the class name in each of our APIs defines the name `Item` as a type parameter, a symbolic
placeholder for some concrete type to be used by the client. You can read `Stack<Item>` as "stacks of items". When
implementing `Stack`, we do not know the concrete type of `Item`, but a client can use our stack for any type of data,
including one defined long after we develop our implementation.

Withoud generics, we would have to define (and implement) different APIs for each type of data we might need to collect;
with generics, we can use one API (and one implementation) for all types of daa, even types that are implemented in the
future.

***Autoboxing***

Java has special mechanisms to allow generic code to be used with primitive types. Java's wrapper types are reference
types that correspond to primitive types: `Boolean, Byte, Chacter, Double, Float, Integer, Long` and `Short`correspond
to `boolean, byte, char, double, float, int, long,`and `short,`respectively. Java automatically converts between these
reference types and the corresponding primitive types.

This conversion is helpful because it enables us to use generics with primitive types, as in the following code:

````java
import java.util.Stack;

class Autoboxing {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(17);         // auto - boxing (int -> Integer)
        int i = stack.pop();    // auto - unboxing (Integer -> int)
    }
}
````

Automatically casting a primitive type to a wrapper type is knows as autoboxing, and automatically casting a wrapper
type to a primitive type is known as auto-unboxing.

***Iterable collections***

This paradigm is so important that it has achieved first-class status in Java and many other modern languages. With it,
we can write clear and compact code that is free from dependence on the details of a collection’s implementation.

````java
import edu.princeton.cs.algs4.Transaction;

class IterableCollections {
    public static void main(String[] args) {
        // each transaction t in the collection, execute the following block of code
        for (Transaction t : collection) {
            StdOut.println(t);
        }
    }
}
````

This client code does not need to know anything about the representation or the implementation of the collection; it
just wants to process each of the items in the collection.

***Bags***

A bag is a collection where removing items is not supported.its purpose is to provide clients with the ability to
collect items and then to iterate through the collected items. The order of iteration is unspecified and should be
immaterial to the client.

```java
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty())
            numbers.add(StdIn.readDouble());
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum / N;
        sum = 0.0;
        for (double x : numbers)
            sum += (x - mean) * (x - mean);
        double std = Math.sqrt(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
```

***FIFO queues***

A FIFO queue(or just a queue) is a collection that is based on the first in- first-out(FIFO) policy.

We enqueue the numbers from the file, use the size() method from Queue to find the size needed for the array, create the
array, and then dequeue the numbers to move them to the array. A queue is appropriate because it puts the numbers into
the array in the order in which they appear in the file.

````java
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

// Sample Queue Client
class FIFO {
    public static int[] readInts(String name) {
        In in = new In(name);
        Queue<Integer> integerQueue = new Queue<>();
        while (!in.isEmpty())
            integerQueue.enqueue(in.readInt());
        int N = integerQueue.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = integerQueue.dequeue();
        return a;
    }
}
````

***Pushdown stacks***

A pushdown stack (or just a stack) is a collection that is based on the last-in-first-out(LIFO) policy.

The LIFO policy offered by a stack provides just the behavior that you expect. When a client iterates through the items
in a stack with the foreach construct, the items are processed in the reverse of the order in which they were added. A
typical reason to use a stack iterator in an application is to save items in a collection while at the same time
reversing their relative order.

````java
public class Reverse {
    public static void main(String[] args) {
        // Sample Stack client
        Stack<Integer> stack;
        stack = new Stack<Integer>();
        while (!StdIn.isEmpty())
            stack.push(StdIn.readInt());
        for (int i : stack)
            StdOut.println(i);
    }
}
````

***Arithmetic expression evaluation***

An arithmetic expression is either a number, or a left parenthesis followed by an arithmetic expression followed by an
operator followed by another arithmetic expression followed by a right parenthesis.

Our focus is on understanding how to interpret the string of parentheses, operators, and numbers to enable performing in
the proper order the low-level arithmetic operations that are available on any computer.

Proceeding from left to right and taking these entities one at a time, we manipulate the stacks according to four
possible cases, as follows:

- Push operands onto the operand stack.
- Push operators onto the operator stack.
- Ignore left parentheses.
- On encountering a right parenthesis, pop an operator, pop the requisite number of operands, and push onto the operand
  stack the result of applying that operator to those operands.

```java
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            // Read token, push if operator.
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            // Token not operator or paren: push double value.
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
```

<a name="122"></a>

#### Implementing collections

***Fixed-capacity stack***

***Generics***

***Array resizing***

***Loitering***

***Iteration***

<a name="123"></a>

#### Linked Lists

***Node record***

***Building a linked list***

***Insert at the beginning***

***Remove from the beginning***

***Insert at the end***

***Insert / remove at other positions***

***Traversal***

***Stack implementation***

***Queue implementation***

***Bag implementation***

## Resources

- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
- [Algorithms, Part 1 - Coursera](https://www.coursera.org/learn/algorithms-part1)
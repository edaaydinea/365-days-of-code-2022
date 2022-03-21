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

Without generics, we would have to define (and implement) different APIs for each type of data we might need to collect;
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

A bag is a collection where removing items is not supported. Its purpose is to provide clients with the ability to
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

***Push down stacks***

A push-down stack (or just a stack) is a collection that is based on the last-in-first-out(LIFO) policy.

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
The API differs from our Stack API: it works only for String values, it requires the client to specify a capacity, and
it does not support iteration. The primary choice in developing an API implementation is to choose a representation for
the data.

For `FixedCapcpcityStackOfStrings`, an obvious choice to use an array of String values.

The instance variables are an array a[] that holds the items in the stack and an integer N that counts the number of
items in the stack. To remove an item, we decrement N and then return a[N]; to insert a new item, we set a[N] equal to
the new item and then increment N. These operations preserve the following properties:

- The items in the array are in their order.
- The stack is empty when N is 0.
- The top of the stack (if it is nonempty) is at a[N-1].

````java
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public String peek() {
        return a[N - 1];
    }

    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }


    public class ReverseArrayIterator implements Iterator<String> {
        private int i = N - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (stack.isEmpty()) StdOut.println("BAD INPUT");
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
} 
````

***Generics***

If we want a stack of double values, we would need to develop another class with similar code, essentially replacing
String with double everywhere.

We replace every occurrence of String with Item and declare the class with the following first line of code:

    public class FixedCapacityStack<Item>

The name `Item` is a _type parameter_, a symbolic placeholder for sme concrete type to be used by the client. You can
read `FixedCapacityStack<Item>` as _stack of items_, which is precisely what we want. When
implementing `FixesCapacityStack` we do not know the actual type of `Item`, but a client can use our stack for any type
of data by providing a concrete type when the stack is created. Concrete types must be reference types, but clients can
depend on autoboxing to convert primitive types to their corresponding wrap per types.

````java
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] a;    // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStack(int capacity) {
        a = (Item[]) new Object[capacity];   // no generic array creation
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }


    public class ReverseArrayIterator implements Iterator<Item> {
        private int i = N - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (stack.isEmpty()) StdOut.println("BAD INPUT");
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
} 
````

***Array resizing***

In Java, we cannot change the size of an array once created, so the stack always uses space proportional to that
maximum. A client that chooses a large capacity risks wasting a large amount of memory at times when the collection is
empty or nearly empty.

Moreover, every client risks overflow if the collection grows larger than the array.

With this implementation, the stack never overflows and never becomes less than one quarter full.

```java
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ResizingArrayStack<Item> implements Iterable<Item> {

    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;

    private Item[] a;         // array of items
    private int n;            // number of elements on stack


    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
        return n;
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;

        // textbook implementation
        Item[] copy = (Item[]) new Object[capacity];
        if (n >= 0) System.arraycopy(a, 0, copy, 0, n);
        a = copy;

        // alternative implementation
        // a = java.util.Arrays.copyOf(a, capacity);
    }


    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(Item item) {
        if (n == a.length) resize(2 * a.length);    // double size of array if necessary
        a[n++] = item;                            // add item
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n - 1];
        a[n - 1] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n - 1];
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n - 1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }


    /**
     * Unit tests the {@code Stack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
```

***Loitering***

Java’s garbage collection policy is to reclaim the memory associated with any objects that can no longer be accessed.

Even when the client is done with the item, the reference in the array may keep it alive. This condition (holding a
reference to an item that is no longer needed)
is known as loitering .

```java
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ResizingArrayQueue<Item> implements Iterable<Item> {
    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;

    private Item[] q;       // queue elements
    private int n;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot


    /**
     * Initializes an empty queue.
     */
    public ResizingArrayQueue() {
        q = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    // resize the underlying array
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last = n;
    }

    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
    public void enqueue(Item item) {
        // double size of array if necessary and recopy to front of array
        if (n == q.length) resize(2 * q.length);   // double size of array if necessary
        q[last++] = item;                        // add item
        if (last == q.length) last = 0;          // wrap-around
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;                            // to avoid loitering
        n--;
        first++;
        if (first == q.length) first = 0;           // wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == q.length / 4) resize(q.length / 2);
        return item;
    }

    /**
     * Returns the item least recently added to this queue.
     * @return the item least recently added to this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }


    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    /**
     * Unit tests the {@code ResizingArrayQueue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }

}

```

***Iteration***

Iterators are generic, so we can use our parameterized type Item to allow clients to iterate through objects of whatever
type is provided by our client.

What is an iterator? An object from a class that implements the methods hasNext() and next()

```java
import java.util.Iterator;

class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    // stack items
    private int N = 0;

    // number of items
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        // Move stack to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void push(Item item) {
        // Add item to top of stack.
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        // Remove item from top of stack.
        Item item = a[--N];
        a[N] = null;
        // Avoid loitering (see text).
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // Support LIFO iteration.
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }
}
```

<a name="123"></a>

#### Linked Lists

A linked list is a recursive data structure that is either empty (null) or a reference to a node having a generic item
and a reference to a linked list.

***Node record***

A `Node` has two instance variables: an `Item` (a parametrized type) and a `Node`.

- We define `Node` within the class where we want to use it, and make it `private` because iy not for use by clients.
- The `Item` is placeholder for any data that we might want to structure with a linked list.
- The instance variable of type `Node` characterizes the linked nature of the data structure.
- If `first` is a variable associated with an object of type `Node`, we can refer to the instance variables with the
  code `first.item`and `first.next`. Classes of this kind are sometimes called `records`.

***Building a linked list***

We can represent a linked list with a variable of type Node simply by ensuring that its value is either _null_ or a
reference t oa `Node` whose `next`field is a reference to a linked list.

````java

class Node {
    public String item;
    private Node next;

    public Node(String item) {
        this.item = item;
        this.next = null;
    }

    public void setNextNode(Node node) {
        this.next = node;
    }

    public Node getNextNode() {
        return this.next;
    }

    public static void main(String[] args) {
        Node first = new Node("to");
        Node second = new Node("be");
        Node third = new Node("or");

        first.setNextNode(second);
        second.setNextNode(third);
    }
}


````

`third.setNextNode` remains null, the value it initialized to at the time of creation.

As a result, `third` is a linked list (it is a reference to a node that has a reference to `null` , which is the null
reference to an empty linked list), and `second` is a linked list (it is a reference to a node that has a reference to
`third` , which is a linked list), and `first` is a linked list (it is a reference to a node that has a reference
to `second`
, which is a linked list)

    A linked list represents a sequence of items.

The difference is that it is easier to insert items into the sequence and to remove items from the sequence with linked
lists.

When tracing code that uses linked lists and other linked structures, we use a visual representation where

- We draw a rectangle to represent each object
- We put the values of instance variables within the rectangle
- We use arrows that point to the referenced objects to depict references

***Insert at the beginning***

````java
// save a link to the list
Node oldfirst=first;

// create a new node for the beginning
        first=New Node();

// set the instance variables in the new node
        first.item="not";
        first.next=oldfirst;
````

***Remove from the beginning***

Normally, you would retrieve the value of the item (by assigning it to some variable of type `Item`) before doing this
assignment, because once you change the value of first, you may not have any access to the node to which it was
referring. Typically, the node object becomes na orphan, and the Java memory management system eventually reclaims the
memory it occupies.

***Insert at the end***

We need a link to the last node in the list, because that node’s link has to be changed to reference a new node
containing the item to be inserted.Maintaining an extra link is not something that should be taken lightly in
linked-list code, because every method that modifies the list needs code to check whether that variable needs to be
modified (and to make the necessary modifications).

    This code does not work in the case the list is empty.

````java
// save a link to the last node
Node oldlast=last;

// create a new node for the end
        last=new Node();
        last.item="not";

// link the new node to the end of the list
        oldlast.next=last;
````

***Insert / remove at other positions***

Other operations, such as the following, are not so easily handled:

- Remove a given node.
- Insert a new node before a given node

In the absence of any other information, the only solution is to traverse the entire list looking for the node that
links to last. Such a solution is undesirable because it takes time proportional to the length of the list.

***Traversal***

This idiom is as natural as the standard idiom for iterating through the items in an array.

***Stack implementation***

It maintains the stack as a linked list, with the top of the stack at the beginning, referenced by an instance variable
first .

1. to push() an item, we add it to the beginning of the list
2. to pop() an item, we remove it from the beginning of the list
3. to implement size(), we keep track of the number of items in an instance variable N, incrementing N when we push and
   decrementing N when we pop.
4. to implement `isEmpty()` we check whether first is null

This use of linked lists achieves our optimum design goals:

- It can be used for any type of data.
- The space required is always proportional to the size of the collection.
- The time per operation is always independent of the size of the collection.

````java
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.ListIterator;

public class Stack<Item> //implements Iterable <Item>
{
    private Node first; // top of stack (most recently added node)
    private int N; // number of items

    private class Node {
        //nested clas to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        // Add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        // Remove item from top of stack
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolena hasNext() {
            return current != null;
        }

        public void remove() {
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        // Create a stack and push / pop strings as directed on StdIn
        Stack<String> stringStack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stringStack.push(item);
            else if (!stringStack.isEmpty())
                StdOut.print(stringStack.pop() + " ");
        }

        StdOut.println("(" + stringStack.size() + " left on stack)");
    }
}
````

***Queue implementation***

An implementation of our Queue API based on the linked-list data structure is also straightforward. It maintains the
queue as a linked list in order from least recently to most recently added items, with the beginning of the queue
referenced by an instance variable first and the end of the queue referenced by an instance variable last.

    Thus, 
    - to enqueue() an item, we add it to the end of the list.
    - to dequeue() an item, we remove it from the beginning of the list

    The implementation of size() and isEmpty() are the same as for Stack.

As with Stack the implementation use the generic type parameter Item, and we omit the code to support iteration.

This implementation uses the same _data structure_ as does Stack --a linked list-- but it implements different _
algorithms_ for adding and removing items, which make the difference between LIFO and FIFO for the client.

The use of linked lists achieves our optimum design goals: it can be used for any type of data, the space required is
proportional to the number of items in the collection, and the time required per operation is always independent of the
size of the collection.

```java
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

class Queue<Item> // implements Iterable <Item>
{
    private Node first; // link to least recently added node
    private Node last; // link to most recently added node
    private int N; // number of items on the queue


    private class Node {
        // nested class to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        // Add item to the end of the list.
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        // Remove item from the beginning of the list
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolena hasNext() {
            return current != null;
        }

        public void remove() {
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}

    public static void main(String[] args) {
        // Create a stack and push / pop strings as directed on StdIn
        Queue<String> stringQueue = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stringQueue.push(item);
            else if (!stringQueue.isEmpty())
                StdOut.print(stringQueue.pop() + " ");
        }

        StdOut.println("(" + stringQueue.size() + " left on queue)");
    }
}
```

Linked lists are a fundamental alternative to arrays for structuring a collection of data.

***Bag implementation***

Implementing our Bag API using a linked-list data structure is simply a matter of changing the name of push()
in Stack to add()
and removing the implementation of pop().

This implementation also highlights the code needed to make Stack , Queue , and Bag all iterable, by traversing the
list.

For Stack the list is in LIFO order; for Queue it is in FIFO order; and for Bag it happens to be in LIFO order, but the
order is not relevant.

````java
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first; // first node in list

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolena hasNext() {
            return current != null;
        }

        public void remove() {
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
````

## Resources

- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
- [Algorithms, Part 1 - Coursera](https://www.coursera.org/learn/algorithms-part1)
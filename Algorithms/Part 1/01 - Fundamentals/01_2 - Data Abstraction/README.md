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

Programming in Java is largely based on building data types. This stype of programming is known as object-oriented
programming, as it revolves around the concept of an object, an entity that holds a data type value. With Java's
primitive types we are largely confined to programs that operate on numbers, but with reference types we can write
programs that operate on strings, pictures, sounds, or any of hundreds of other abstractions that are available in
Java's standard libraries or on our booksite. Even more significant than libraries of predefined data types is that the
range of data types available in Java programming is open-ended, because you can define your own data types.

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

<a name="121"></a>

#### Using abstract data types

***API for an abstract data type***

***Inherited methods***

***Client code***

***Objects***

***Creating objects***

***Invoking instance methods***

***Using objects***

***Assignment statements***

***Objects as arguments***

***Objects as return values***

***Arrays are objects***

***Arrays of objects***

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
# Algorithms - Part 1

**TABLE OF CONTENTS**

1. [Fundamentals](#fundamentals)
    1. [Programming Model]()
        1. [Primitive data types and expressions]()
        2. [Statements]()
        3. [Arrays]()
        4. [Static Methods]()
        5. [Recursion]()
        6. [APIs]()
        7. [Strings]()
        8.

## 1. Fundamentals

Rather than the computer itself, it is the method that specifies the steps that we can take to solve the problem. The
term *algorithm* is used in computer science to describe a finite, deterministic, and effective problem-solving method
suitable for implementation as a computer program.

We can define, an algorithm by describing a procedure for solving a problem in natural language, or by writing a
computer program that implements the procedure.

```
"""
Compute the greatest common divisor of two nonnegative integers p and q as follows:
	- If q is 0, the answer is p.
	- If not, divide p by q and take the remainder r.
	- The answer is the greatest common divisor of q and r.
"""
public static int gcd(int p, int q)
{
	if (q == 0) return p;
	int r = p % q;
	return gcd(q, r);
}
```

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

### 1.1 Programming Model

Our study of Algorithms is based upon implementing them as programs written in the Java programming language. We do so
for several reasons:

- Our programs are concise, elegant, and complete descriptions of algorithms.
- You can run the programs to study the properties of the algorithms.
- You can put the algorithms immediately to good use in applications.

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

#### Arrays

An *array* stores a sequence of value that are all of the same type.If we have `N` values, we can use the
notation `a[i]`to refer to the ith value for any value of `i`from `0` to `N-1`.

- ***Creating an

## Resources

- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
- [Algorithms, Part 1 - Coursera](https://www.coursera.org/learn/algorithms-part1)
- [Algorithms, Part 2 - Coursera](https://www.coursera.org/learn/algorithms-part2)

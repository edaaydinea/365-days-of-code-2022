# Algorithms - Part 1 

## 1. Fundamentals

Rather than the computer itself, it is the method that specifies the steps that we can take to solve the problem. The term *algorithm* is used in computer science to describe a finite, deterministic, and effective problem-solving method suitable for implementation as a computer program.

We can define, an algorithm by describing a procedure for solving a problem in natural language, or by writing a computer program that implements the procedure.

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

One important reason for doing so is that it makes easier the task of checking whether they are finite, deterministic, and effective, as required.

Most algorithms of interest involve organizing the data involved in the computation.

Simple algorithms can give rise to complicated data structures and, conversely, complicated algorithms can use simple data structures.

The primary reason to learn about algorithms is that this discipline gives us the potential to reap huge savings, even to the point of enabling us to do tasks that would otherwise be impossible.

Careful algorithm design is an extremely effective part of the process of solving a huge problem, whatever the applications area.

When developing a huge or complex computer program, a great deal of effort must go into understanding and defining the problem to be solved, managing its complexity, and decomposing it into smaller subtasks that can be implemented easily.

Implementing simple versions of basic algorithms helps us to understand them better, and thus to more effectively use and tune advanced versions from a library. More importantly, the opportunity to reimplement basic algorithms arises frequently.

Choosing the best algorithm for a particular task can be a complicated process, perhaps involving sophisticated mathematical analysis. The branch of computer science that comprises the study of such questions is called the *analysis of algorithms*.


### 1.1 Programming Model

Our study of Algorithms is based upon implementing them as programs written in the Java programming language. We do so for several reasons:

- Our programs are concise, elegant, and complete descriptions of algorithms.
- You can run the programs to study the properties of the algorithms.
- You can put the algorithms immediately to good use in applications.

**Primitive data types and expressions.**
A data type is a set of values and a set of operations on those values. The following four primitive data types are the basis of the Java language:
- *Integers*, with arithmetic operations (int)
- *Real numbers*, again with arithmetic operations (double)
- *Booleans*, the set of values {true, false} with logical operations (booelean)
- *Characters*, the alphanumeric characters and symbols that you type (char)

A Java program manipulates variables that are named with identifiers. Each variable is associated with a data type and stores one of the permissible data-type values. We use expressions to apply the operations associated with each type.

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

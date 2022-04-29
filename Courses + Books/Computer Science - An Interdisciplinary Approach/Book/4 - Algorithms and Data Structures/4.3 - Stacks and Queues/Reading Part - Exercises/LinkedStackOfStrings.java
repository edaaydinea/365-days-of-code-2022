/******************************************************************************
 *  Compilation:  javac LinkedStackOfStrings.java
 *  Execution:    java LinkedStackOfStrings
 *  Data files:   https://introcs.cs.princeton.edu/java/43stack/tobe.txt
 *
 *  A stack of strings, implemented using a linked list.
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java LinkedStackOfStrings < tobe.txt 
 *  to be not that or be
 *  
 ******************************************************************************/

import java.util.NoSuchElementException;

public class LinkedStackOfStrings {
    private int n;          // size of the stack
    private Node first;     // top of stack

    // helper Node class
    private class Node {
        private String item;
        private Node next;
    }

    // is the stack empty?
    public boolean isEmpty() {
        return first == null;
    }

    // number of elements on the stack
    public int size() {
        return n;
    }


    // add an element to the stack
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    // delete and return the most recently added element
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        String item = first.item;      // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    // test client
    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))     stack.push(item); 
            else if (stack.isEmpty())  StdOut.println("BAD INPUT"); 
            else                       StdOut.print(stack.pop());
        } 
    } 


}

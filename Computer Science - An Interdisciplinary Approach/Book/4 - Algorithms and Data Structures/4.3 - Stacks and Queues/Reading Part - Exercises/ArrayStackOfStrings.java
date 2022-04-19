/******************************************************************************
 *  Compilation:  javac ArrayStackOfStrings.java
 *  Execution:    java ArrayStackOfStrings
 *  Data files:   https://introcs.cs.princeton.edu/java/43stack/tobe.txt
 *  
 *  Stack of strings implementation with a fixed-size array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java ArrayStackOfStrings 5 < tobe.txt 
 *  to be not that or be
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStackOfStrings implements Iterable<String> {
    private String[] items;  // holds the items
    private int n;           // number of items in stack

    public ArrayStackOfStrings(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0; 
    }

    public boolean isFull() {
        return n == items.length; 
    }

    public void push(String item) {
        items[n++] = item;
    }

    public String pop() {
        return items[--n];
    }

    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<String> {
        private int i = n-1;
        public boolean hasNext()  { return i >= 0;                              }
        public void remove()      { throw new UnsupportedOperationException();  }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[i--];
        }
    }


    public static void main(String[] args) {
        int capacity = Integer.parseInt(args[0]);
        ArrayStackOfStrings stack = new ArrayStackOfStrings(capacity);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item); 
            }
            else {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println();
    } 
} 

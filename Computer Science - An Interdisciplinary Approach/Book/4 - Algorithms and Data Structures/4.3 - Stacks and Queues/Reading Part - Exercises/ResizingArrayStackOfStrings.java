/******************************************************************************
 *  Compilation:  javac ResizingArrayStackOfStrings.java
 *  Execution:    java ResizingArrayStackOfStrings < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://introcs.cs.princeton.edu/java/43stack/tobe.txt
 *  
 *  Stack implementation with a resizing array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java ResizingArrayStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStackOfStrings implements Iterable<String> {
    private String[] items;     // array of strings
    private int n = 0;          // number of elements on stack

    // create an empty stack
    public ResizingArrayStackOfStrings() {
        items = new String[2];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        String[] temp = new String[capacity];
        for (int i = 0; i < n; i++)
            temp[i] = items[i];
        items = temp;
    }

    // push a new item onto the stack
    public void push(String item) {
        if (n == items.length) resize(2*items.length);  // double array length if necessary
        items[n++] = item;                              // add item
    }

    // delete and return the item most recently added
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        String item = items[n-1];
        items[n-1] = null;        // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == items.length/4) resize(items.length/2);
        return item;
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



   /***************************************************************************
    * Test routine.
    ***************************************************************************/
    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}

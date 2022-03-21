import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_07 {
    public static class FixedCapacityStackOfStrings {
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

        public int size() {
            return N;
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


        public static void main(String[] args) {
            StdOut.print("How many strings will you enter?");
            int number = StdIn.readInt();
            FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(number);

            for (int i = 0; i < number; i++) {
                String string = StdIn.readString();
                fixedCapacityStackOfStrings.push(string);
            }

            if (fixedCapacityStackOfStrings.isFull())
                StdOut.println("Stack is full!");
            else
                StdOut.println("Stack is not full!");

        }
    }
}



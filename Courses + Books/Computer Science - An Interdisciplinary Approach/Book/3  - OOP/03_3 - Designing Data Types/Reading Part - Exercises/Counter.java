/******************************************************************************
 *  Compilation:  javac Counter.java
 *  Execution:    java Counter
 *  Dependencies: StdRandom.java StdOut.java
 *
 *  % java Counter 6 600000
 *  0: 99870
 *  1: 99948
 *  2: 99738
 *  3: 100283
 *  4: 100185
 *  5: 99976
 *
 ******************************************************************************/

public class Counter implements Comparable<Counter> {

    private final String name;     // counter name
    private final int maxCount;    // maximum value
    private int count;             // current value

    // create a new counter with the given parameters
    public Counter(String id, int max) {
        name = id;
        maxCount = max;
        count = 0;
    } 

    // increment the counter by 1
    public void increment() {
        if (count < maxCount) count++;
    } 

    // return the current count
    public int value() {
        return count;
    } 

    // return a string representation of this counter
    public String toString() {
        return name + ": " + count;
    } 

    // compare two Counter objects based on their count
    public int compareTo(Counter that) {
        if      (this.count < that.count) return -1;
        else if (this.count > that.count) return +1;
        else                              return  0;
    }


    // test client
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // create n counters
        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++) {
            hits[i] = new Counter(i + "", trials);
        }

        // increment trials counters at random
        for (int t = 0; t < trials; t++) {
            int index = StdRandom.uniform(n);
            hits[index].increment();
        }

        // print results
        for (int i = 0; i < n; i++) {
            StdOut.println(hits[i]);
        }
    } 
} 

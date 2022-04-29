/******************************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/java/43sort/8words.txt
 *                https://introcs.cs.princeton.edu/java/43sort/TomSawyer.txt
 *  
 *  Reads in strings from standard input and prints them in sorted order.
 *  Uses insertion sort.
 *
 *  % java Insertion < 8words.txt
 *  and but had him his the was you 
 *
 ******************************************************************************/

public class Insertion {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j-1].compareTo(a[j]) > 0) {
                    exch(a, j-1, j);
                }
                else break;
            }
        }
    }

    // exchange a[i] and a[j]
    @SuppressWarnings("rawtypes")
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // read in a sequence of words from standard input and print
    // them out in sorted order
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}



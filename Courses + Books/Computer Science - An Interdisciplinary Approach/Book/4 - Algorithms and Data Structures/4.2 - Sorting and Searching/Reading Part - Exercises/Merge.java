/******************************************************************************
 *  Compilation:  javac Merge.java
 *  Execution:    java Merge < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/java/43sort/8words.txt
 *                https://introcs.cs.princeton.edu/java/43sort/TomSawyer.txt
 *
 *  A bare-bones n log n implementation of mergesort.
 *
 *  Remarks
 *  ---------
 *     - number of comparisons is guaranteed to be at most n lg n
 *     - sort is stable
 *
 *  % java Merge < 8words.txt
 *  and but had him his the was you 
 *
 ******************************************************************************/

public class Merge {

   /***************************************************************************
    *  Merge the subarrays a[lo] .. a[mid-1] and a[mid] .. a[hi-1] into
    *  a[lo] .. a[hi-1] using the auxilliary array aux[] as scratch space.
    *
    *  Precondition:   the two subarrays are in ascending order
    *  Postcondition:  a[lo] .. a[hi-1] is in ascending order
    *
    ***************************************************************************/
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if      (i == mid)                 aux[k] = a[j++];
            else if (j == hi)                  aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else                               aux[k] = a[i++];
        }

        // copy back
        for (int k = lo; k < hi; k++)
            a[k] = aux[k];
    }


   /***************************************************************************
    *  Mergesort the subarray a[lo] .. a[hi-1], using the
    *  auxilliary array aux[] as scratch space.
    ***************************************************************************/
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        // base case
        if (hi - lo <= 1) return;

        // sort each half, recursively
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);

        // merge back together
        merge(a, aux, lo, mid, hi);
    }


   /***************************************************************************
    *  Sort the array a using mergesort.
    ***************************************************************************/
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, 0, n);
    }

   /***************************************************************************
    *  Sort the subarray a[lo..hi] using mergesort.
    ***************************************************************************/
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, lo, hi);
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }

   /***************************************************************************
    *  Show results.
    ***************************************************************************/
    @SuppressWarnings("rawtypes")
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }


   /***************************************************************************
    *  Test client.
    ***************************************************************************/
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        assert isSorted(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}

public class Exercise_05 {
    public static class Merge {
        private static Comparable[] aux;

        public static void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {
            System.out.printf("%3d", hi-lo+1);
            int i = lo, j = mid + 1;
            if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
            for (int k = lo; k <= hi; k++)
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else a[k] = aux[i++];
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

    public static class MergeBU {
        private static Comparable[] aux;

        public static void sort(Comparable[] a) {
            int N = a.length;
            aux = new Comparable[N];
            for (int sz = 1; sz < N; sz = sz+sz) {
                for (int lo = 0; lo < N - sz; lo += sz + sz) {  
                    merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
                }
            }
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {
            System.out.printf("%3d", hi-lo+1);
            // Merge a[lo..mid] with a[mid+1..hi].
            int i = lo, j = mid + 1;
            // Copy a[lo..hi] to aux[lo..hi].
            if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
            for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else a[k] = aux[i++];
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

    public static void main(String[] args) {
        int n = 39;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        System.out.println("Merge:");
        Merge.sort(a);
        System.out.println();
        System.out.println("MergeBU:");
        MergeBU.sort(a);
    }
}

import edu.princeton.cs.algs4.StdRandom;

public class Exercise_09 {
    public static class Quick{
        static int ecount;

        public static int sort(Comparable[] a){
            StdRandom.shuffle(a);
            ecount = 0;
            sort(a, 0, a.length - 1);
            return ecount;
        }

        private static void sort(Comparable[] a, int low, int high){
            if (high <= low)
        }
    }
}

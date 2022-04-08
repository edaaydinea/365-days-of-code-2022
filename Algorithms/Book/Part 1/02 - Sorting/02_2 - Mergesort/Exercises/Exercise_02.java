public class Exercise_02 {
    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split("\\s+");
        Merge.sort(a);
    }

    private static class Merge {
        private static Comparable[] aux;

        public static void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);

        }

        private static void sort(Comparable[] a, int lower, int high) {
            if (high <= lower) return;
            int mid = lower + (high - lower) / 2;
            sort(a, lower, mid);
            sort(a, mid + 1, high);
            merge(a, lower, mid, high);

            System.out.printf("Merge ( a, %2d, %2d, %2d", lower, mid, high);
            for (int i = lower; i <= high; i++) {
                System.out.printf("%3s", a[i]);
            }
            System.out.println();
        }

        public static void merge(Comparable[] a, int low, int mid, int high) {
            int i = low, j = mid + 1;
            for (int k = low; k <= high; k++) {
                aux[k] = a[k];
            }
            for (int k = low; k <= high; k++)
                if (i > mid) a[k] = aux[j++];
                else if (j > high) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else a[k] = aux[i++];

        }

        private static boolean less (Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }
}


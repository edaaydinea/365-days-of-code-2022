public class Exercise_03 {
    public static class MergeBU {
        private static Comparable[] aux;

        public static void sort(Comparable[] a) {
            int N = a.length;
            aux = new Comparable[N];
            for (int size = 1; size < N; size = size+size) {
                for (int low = 0; low < N - size; low += size + size) {
                    merge(a, low, low + size - 1, Math.min(low + size + size - 1, N - 1));
                    // Print for exercise
                    System.out.printf("merge(a, %2d, %2d, %2d) ", low, low + size - 1, Math.min(low + size + size - 1, N - 1));
                    for (int i = low; i <= Math.min(low + size + size - 1, N - 1); i++) {
                        System.out.printf("%3s", a[i]);
                    }
                    System.out.println();

                }
            }
        }

        public static void merge(Comparable[] a, int low, int mid, int high) {
            int i = low, j = mid + 1;
            if (high + 1 - low >= 0) System.arraycopy(a, low, aux, low, high + 1 - low);
            for (int k = low; k <= high; k++)
                if (i > mid) a[k] = aux[j++];
                else if (j > high) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else a[k] = aux[i++];
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split("\\s+");
        MergeBU.sort(a);
    }
}

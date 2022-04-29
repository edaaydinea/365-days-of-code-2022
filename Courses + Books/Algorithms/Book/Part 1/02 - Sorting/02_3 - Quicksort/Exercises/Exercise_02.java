import java.util.Arrays;

public class Exercise_02 {
    public static class Quick{
        public static void sort(Comparable[] a){
            sort(a, 0, a.length - 1);
        }
        private static void sort(Comparable[] a, int low, int high){
            if(high <= low) {
                System.out.printf("%4d %4s %4d %s\n", low, "-", high, Arrays.toString(a));
                return;
            }
            int mid = partition(a,low,high);
            System.out.printf("%4d %4d %4d %s\n", low, mid, high, Arrays.toString(a));
            sort(a,low, mid-1);
            sort(a,mid+1, high);
        }

        private static int partition(Comparable[] a, int low, int high){
            // Partition intro a[low ... i-1], a[i], a[i+1 ... high]
            int i = low, j = high + 1;
            Comparable v = a[low];
            while(true){
                while (less(a[++i], v)) if (i == high) break;
                while (less(v,a[--j])) if (j == low) break;
                if(i>= j) break;
                exch(a,i,j);
            }
            exch(a, low, high);
            return j;
        }

        private static boolean less(Comparable a, Comparable b){
            return a.compareTo(b) < 0;
        }

        private static void exch(Comparable[] a, int i , int j){
            Comparable copy = a[i];
            a[i] = a[j];
            a[j] = copy;
        }
    }

    public static void main(String[] args) {
        String[] s = "E A S Y Q U E S T I O N".split("\\s+");
        Quick.sort(s);
    }
}

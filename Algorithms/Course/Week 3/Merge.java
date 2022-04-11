import java.util.Comparator;

public class Merge {
    private static void merge(Comparator[] a, Comparator[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid); // precondition: a[lo.. mid] sorted
        assert isSorted(a,mid+1, hi); // precondition: a[mid + 1... hi] sorted

        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++){
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }

        assert isSorted(a, lo, hi); // post condition: a[lo ... hi] sorted
    }
}

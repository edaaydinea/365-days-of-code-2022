public class Exercise_18<Key extends Comparable<Key> , Value> {
    private final Key[] keys;
    private final Value[] values;
    private int n;

    public Exercise_18(int cap) {
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public int rank(Key key) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }
        return low;
    }
}
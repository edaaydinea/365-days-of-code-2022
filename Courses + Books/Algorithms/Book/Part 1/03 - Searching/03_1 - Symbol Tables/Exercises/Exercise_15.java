import edu.princeton.cs.algs4.*;

import java.util.NoSuchElementException;

public class Exercise_15<Key extends Comparable<Key>, Value> {
    public class Item implements Comparable<Item>{
        private final Key key;
        private Value value;
        public Item(Key key, Value value){
            this.key = key;
            this.value = value;
        }
        public int compareTo(Item that){
            return Integer.compare(this.key.compareTo(that.key), 0);
        }
    }
    private Item[] items;
    private int N;
    @SuppressWarnings("unchecked")
    public Exercise_15(){
        items = new Exercise_15.Item[2];
    }
    /*public Ex15_PercentageOfTotalTime(int cap){
        items = new Ex15_PercentageOfTotalTime.Item[cap];
    }*/
    public Exercise_15(Item[] items){
        Merge.sort(items);
        this.items = items;
        N += items.length;
    }
    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    public int size(Key low, Key high){
        if (low.compareTo(high) >= 0) return 0;
        if (contains(high))
            return rank(high) - rank(low) + 1;
        else
            return rank(high) - rank(low);
    }
    public boolean contains(Key key){
        if (key == null)
            throw new IllegalArgumentException("Argument key cannot be null. ");
        return get(key) != null;
    }
    public Value get(Key key){
        if (key == null)
            throw new IllegalArgumentException("Argument key cannot be null. ");
        int i = rank(key);
        if (key.compareTo(items[i].key) == 0){
            return items[i].value;
        }
        else
            return null;
    }
    public int rank(Key key){
        int low = 0;
        int high = N - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            int cmp = key.compareTo(items[mid].key);
            if (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }
        return low;
    }
    public void delete(Key key){
        if (key == null)
            throw new IllegalArgumentException("Argument key cannot be null. ");
        if (isEmpty() || !contains(key))
            return;
        if (N > 1 && N == items.length / 4){
            resize(N / 2);
        }
        int i = rank(key);
        if (N - 1 - i >= 0) System.arraycopy(items, i + 1, items, i, N - 1 - i);
        items[N-1] = null;
        N--;
    }
    public void put(Key key, Value value){
        if (key == null)
            throw new IllegalArgumentException("Argument key cannot be null. ");
        if (value == null){
            delete(key);
        }
        if (N == items.length / 2){
            resize(N * 2);
        }
        int i = rank(key);
        if (key.compareTo(items[i].key) == 0){
            items[i].value = value;
        }
        if (N - i >= 0) System.arraycopy(items, i, items, i + 1, N - i);
        items[i] = new Item(key, value);
        N++;
    }
    public Key min(){
        if (isEmpty()){
            throw new NoSuchElementException("Empty symbol table");
        }
        return items[0].key;
    }
    public Key max(){
        if (isEmpty()){
            throw new NoSuchElementException("Empty symbol table");
        }
        return items[N-1].key;
    }
    @SuppressWarnings("unchecked")
    public void resize(int newSize){
        Item[] temp = new Exercise_15.Item[newSize];
        if (N >= 0) System.arraycopy(items, 0, temp, 0, N);
        items = temp;
    }
    public Iterable<Key> keys(Key low, Key high){
        Queue<Key> queue = new Queue<>();
        for (int i = rank(low); i < rank(high); i++){
            queue.enqueue(items[i].key);
        }
        if (contains(high))
            queue.enqueue(high);
        return queue;
    }
    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public double timeCost(String s, Item[] items){
        Stopwatch timer = new Stopwatch();
        Exercise_15<Integer, String> percentageOfTotalTime = new Exercise_15<>();
        if (s.equals("Insert")){
            for (Integer t : percentageOfTotalTime.keys()){
                percentageOfTotalTime.put(t, percentageOfTotalTime.get(t));
            }
        }
        if (s.equals("Search")){
            for (Integer t : percentageOfTotalTime.keys()){
                percentageOfTotalTime.get(t);
            }
        }
        return timer.elapsedTime();
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Exercise_15 time = new Exercise_15();
        for (int N = 1000; N < 1000000000; N *= N){
            Exercise_15.Item[] items = new Exercise_15.Item[N];
            for (int i = 0; i < N; i++){
                items[i] = new Exercise_15().new Item(i, "value" + i);
            }
            StdOut.print("Percentage of Time: ");
            double timeForInsertion = time.timeCost("Insert", items);
            double timeForSearch = time.timeCost("Search", items);
            StdOut.println(timeForInsertion / (timeForInsertion + timeForSearch));
        }
    }
}

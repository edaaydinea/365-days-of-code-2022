import edu.princeton.cs.algs4.*;

@SuppressWarnings("unchecked")
public class Exercise_12<Key extends Comparable<Key>, Value> {
    public class Item implements Comparable<Item>{
        private Key key;
        private Value value;
        public Item(Key key, Value value){
            this.key = key;
            this.value = value;
        }
        public int compareTo(Item that){
            if (this.key.compareTo(that.key) < 0) return -1;
            else if (this.key.compareTo(that.key) > 0) return 1;
            return 0;
        }
    }
    private Item[] items;
    private int N;
    public Exercise_12(Item[] items){
        Merge.sort(items);
        this.items = items;
    }
    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    public boolean contains(Item item){
        return get(item) != null;
    }
    public Key select(int k){
        return items[k].key;
    }
    public int rank(Key key){
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(items[mid].key);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    public void resize(int newSize){
        Item[] aux =(Item[]) new Object[newSize];
        for (int i = 0; i < items.length; i++){
            aux[i].key = items[i].key;
            aux[i].value = items[i].value;
        }
        items = aux;
    }
    public void put(Item item){
        if (item.key == null)
            throw new IllegalArgumentException("Key cannot be null. ");
        if (N == items.length / 2){
            resize(2 * items.length);
        }
        int i = rank(item.key);
        if (items[i].key.compareTo(item.key) == 0){
            items[i].value = item.value;
            return;
        }

        for (int j = N; j > i; j--){
            items[j].key = items[j-1].key;
            items[j].value = items[j-1].value;
        }
        items[i].key = item.key;
        items[i].value = item.value;
        N++;

    }
    public Value get(Item item){
        if (item.key == null){
            throw new IllegalArgumentException("Object is null. ");
        }
        if (isEmpty()){
            return null;
        }
        int i = rank(item.key);
        if (item.key.compareTo(items[i].key) == 0){
            return items[i].value;
        }else {
            return null;
        }
    }
    public void delete(Item item){
        if (item.key == null){
            throw new IllegalArgumentException("Key is null. ");
        }
        if (isEmpty()){
            return;
        }
        int i = rank(item.key);
        for (int j = i; j < items.length - 1; j++){
            items[j].key = items[j + 1].key;
            items[j].value = items[j + 1].value;
        }
        items[items.length + 1] = null;
        N--;
    }
    public Key min(){
        if (isEmpty()){
            return null;
        }
        return items[0].key;
    }
    public Key max(){
        if (isEmpty()){
            return null;
        }
        return items[N-1].key;
    }
    public void deleteMin(){
        if (isEmpty()){
            return;
        }
        delete(items[0]);
        N--;
    }
    public void deleteMax(){
        if (isEmpty()){
            return;
        }
        delete(items[N]);
        N--;
    }
    public Key ceiling(Item item){
        if (item == null){
            throw new IllegalArgumentException("item cannot be null. ");
        }
        return item.key;
    }
    public Key floor(Item item){
        if (item == null){
            throw new IllegalArgumentException("item cannot be null. ");
        }
        return item.key;
    }
    public Iterable<Key> keys(Item low, Item high){
        Queue<Key> queue = new Queue<>();
        for (int i = rank(low.key); i < rank(high.key); i++){
            queue.enqueue(items[i].key);
        }
        if (contains(high)){
            queue.enqueue(high.key);
        }
        return queue;
    }
    public Iterable<Key> keys(){
        return keys(items[0], items[N-1]);
    }
    public static void main(String[] args) {
        Exercise_12.Item[] items = new Exercise_12.Item[5];
        Exercise_12<Integer, String> modifyBinarySearchST = new Exercise_12<>(items);
        items[0] = modifyBinarySearchST.new Item(4, "value4");
        items[1] = modifyBinarySearchST.new Item(1, "value1");
        items[2] = modifyBinarySearchST.new Item(6, "value6");
        items[3] = modifyBinarySearchST.new Item(8, "value8");
        items[4] = modifyBinarySearchST.new Item(3, "value3");
        modifyBinarySearchST.put(items[0]);
        for (Integer key : modifyBinarySearchST.keys()){
            StdOut.println("Key: " + key + " " + modifyBinarySearchST.get(items[0]));
        }
        modifyBinarySearchST.put(items[1]);
        modifyBinarySearchST.put(items[2]);
        modifyBinarySearchST.put(items[3]);
        modifyBinarySearchST.put(items[4]);
        modifyBinarySearchST.delete(items[1]);
        modifyBinarySearchST.delete(items[2]);
        modifyBinarySearchST.get(items[0]);
    }
}

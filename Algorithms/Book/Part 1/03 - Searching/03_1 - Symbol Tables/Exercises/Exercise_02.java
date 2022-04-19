import edu.princeton.cs.algs4.Queue;

@SuppressWarnings("unchecked")
public class Exercise_02<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public Exercise_02(int cap){
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
    }

    public Value get(Key key){
        if (key == null)
            throw new IllegalArgumentException("Argument for get() is null");
        //int i = rank(key);
        for (int i = 0; i < keys.length; i++){
            if (keys[i].equals(key))
                return values[i];
        }
        return null;
    }
    public void put(Key key, Value value){
        if (key == null)
            throw new IllegalArgumentException("Argument for put() is null. ");
        if (value == null){
            delete(key);
            return;
        }
        //int i = rank(key);
        for (int i = 0; i < keys.length; i++){
            if (keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }

        keys[N] = key;
        values[N] = value;
        N++;
    }
    public void delete(Key key){

    }
    public boolean isEmpty(){return N == 0;}
    public boolean contains(Key key){return get(key) != null;}
    public int size(){return N;}
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < N; i++){
            queue.enqueue(keys[i]);
        }
        return queue;
    }

}

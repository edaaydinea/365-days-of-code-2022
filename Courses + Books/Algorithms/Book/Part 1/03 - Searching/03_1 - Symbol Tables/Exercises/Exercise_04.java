import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("unchecked")
public class Exercise_04 {
    public static class Time implements Comparable<Time>{
        private final double hour;
        private final double minute;
        private final double second;
        public Time(double hour, double minute, double second){
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        public String toString(){
            return hour + " : " + minute + " : " + second;
        }
        public int compareTo(Time time){
            if (this.hour < time.hour) return -1;
            else if (this.hour > time.hour) return 1;
            else if (this.minute < time.minute) return -1;
            else if (this.minute > time.minute) return 1;
            else return Double.compare(this.second, time.second);
        }
    }
    public static class Event{
        private final String address;
        public Event(String address){
            this.address = address;
        }
        public String toString(){
            return address;
        }
    }
    private int N;
    private Time[] times;
    private Event[] events;
    public Exercise_04(int cap){
        times = (Time[]) new Comparable[cap];
        events = (Event[]) new Object[cap];
    }
    public void resize(int newSize){
        Time[] auxT = (Time[]) new Comparable[newSize];
        Event[] auxE = (Event[]) new Object[newSize];
        for (int i = 0; i < N; i++){
            auxT[i] = times[i];
            auxE[i] = events[i];
        }
        times = auxT;
        events = auxE;
    }
    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    public int rank(Time time){
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            int cmp = time.compareTo(times[mid]);
            if (cmp < 0){return hi = mid - 1;}
            else if (cmp > 0){return lo = mid + 1;}
            else return mid;
        }
        return lo;
    }
    public void put(Time time, Event event){
        int i = rank(time);
        if (N == this.size() / 2){
            resize(N * 2);
        }
        if (i < N && time.compareTo(times[i]) == 0){
            events[i] = event;
            return;
        }
        for (int j = N; j > i; j--){
            times[j] = times[j-1];
            events[j] = events[j-1];
        }
        times[i] = time;
        events[i] = event;
        N++;
    }
    public Event get(Time time){
        int i = rank(time);
        if (N == this.size() / 4){
            resize(N / 2);
        }
        if (time.compareTo(times[i]) == 0){
            return events[i];
        }
        else {
            return null;
        }
    }
    /* public Iterable<Time> times(){
         Queue<Time> times = new Queue<>();
         for (int i = 0; i < times.size(); i++){
             times.enqueue(times[i]);
         }
     }*/
    public static void main(String[] args) {
        //Ex04_TimeAndEventProcessing<Time, Event> searchST = new Ex04_TimeAndEventProcessing(2);
        ST<Time, Event> searchST = new ST();
        searchST.put(new Time(9, 10, 1), new Event("Chicago"));
        searchST.put(new Time(9, 22, 1), new Event("Phoenix"));
        searchST.put(new Time(9, 34, 2), new Event("Houston"));
        searchST.put(new Time(9, 3, 1), new Event("Seattle"));
        searchST.put(new Time(9, 2, 1), new Event("Chicago"));
        searchST.put(new Time(9, 10, 11), new Event("Houston"));

        for (Time time : searchST.keys()){
            StdOut.println(time + " " + searchST.get(time));
        }
    }
}
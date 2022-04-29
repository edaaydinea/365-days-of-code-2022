import edu.princeton.cs.algs4.StdDraw;

/*
Develop a class VisualCounter that allows both increment and decrement
operations. Take two arguments N and max in the constructor, where N specifies the
maximum number of operations and max specifies the maximum absolute value for
the counter. As a side effect, create a plot showing the value of the counter each time its tally changes.
 */
public class Exercise_10 {
    public static class VisualCounter {
        private int times;
        private final int N;
        private final int Max;
        private int count = 0;

        public VisualCounter(int max, int n) {
            times = 0;
            if (max < 0) {
                Max = -max;
                System.out.println("Input max error");
            } else {
                Max = max;
            }
            N = n;

            StdDraw.setXscale(0, n + 1);
            StdDraw.setYscale(-(max + 1), max + 1);
            StdDraw.point(0, 0);
        }

        public void increment() {
            if (times < N && Math.abs(count) < Max) {
                count++;
                times++;
            } else System.out.println("out of N or Max!");
        }

        public void decrement() {
            if (times < N && Math.abs(count) < Max) {
                count--;
                times++;
            } else System.out.println("out of N or Max!");
        }

        public int getTimes() {
            return times;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        int N = 100;
        int Max = 100;
        VisualCounter visualCounter = new VisualCounter(Max, N);
        int count;
        int times;
        for (int i = 0; i < 40; i++) {
            count = visualCounter.getCount();
            times = visualCounter.getTimes();
            visualCounter.increment();
            StdDraw.point(times, count);
        }
        for (int i = 0; i < 30; i++) {
            count = visualCounter.getCount();
            times = visualCounter.getTimes();
            visualCounter.decrement();
            StdDraw.point(times, count);
        }
        for (int i = 0; i < 30; i++) {
            count = visualCounter.getCount();
            times = visualCounter.getTimes();
            visualCounter.increment();
            StdDraw.point(times, count);
        }
    }
}

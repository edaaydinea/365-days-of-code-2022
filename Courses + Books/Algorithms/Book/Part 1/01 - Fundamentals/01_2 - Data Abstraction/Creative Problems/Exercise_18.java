import edu.princeton.cs.algs4.StdRandom;

public class Exercise_18 {
    public static class Accumulator {
        private double m;
        private double s;
        private int N;

        public Accumulator() {
            m = 0;
            s = 0;
            N = 0;
        }

        public void addDaraValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        public double stddev() {
            return Math.sqrt(this.var());
        }

        @Override
        public String toString() {
            return "Mean (" + N + " values ):"
                    + String.format("%7.5f", mean())
                    + " variation : " + var()
                    + " standard deviation :" + stddev();
        }
    }

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        for (int i = 0; i < 10; i++) {
            double temp = StdRandom.uniform(1, 100);
            accumulator.addDaraValue(temp);
        }

        System.out.println(accumulator);
    }
}


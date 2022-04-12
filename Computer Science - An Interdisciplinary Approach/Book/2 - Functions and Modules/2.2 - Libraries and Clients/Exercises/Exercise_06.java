import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_06 {
    public static void main(String[] args) {
        double[] a = new double[10];
        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform(-100, 101); // [-100, 100]

        StdArrayIO.print(a);

        double[] scaled = Scale.linearScale(-10, 10, a);
        StdArrayIO.print(scaled);
    }
}

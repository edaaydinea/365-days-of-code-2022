import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class Exercise_03 {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void drawLogLog(int N) {
        StdDraw.setCanvasSize(200, 600);
        StdDraw.setXscale(Math.log(128), Math.log(N));
        StdDraw.setYscale(-10, 10);
        double x0 = 0;
        double y0 = 0;
        for (int n = 250; n <= N; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);
            double x1 = Math.log(n);
            double y1 = Math.log(time);
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(x1, y1);
            if (x0 == 0 && y0 == 0) {

            } else {
                StdDraw.setPenRadius(0.001);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.line(x0, y0, x1, y1);
            }
            x0 = x1;
            y0 = y1;
        }
    }


    public static void drawStandard(int N) {
        StdDraw.setCanvasSize(400, 400);
        StdDraw.setXscale(0, 10000);
        StdDraw.setYscale(0, 100);
        double x0 = 0;
        double y0 = 0;
        for (int n = 250; n <= N; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);
            double x1 = n;
            double y1 = time;
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(x1, y1);
            if (x0 == 0 && y0 == 0) {

            } else {
                StdDraw.setPenRadius(0.001);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.line(x0, y0, x1, y1);
            }
            x0 = x1;
            y0 = y1;
        }
    }

    public static void main(String[] args) {
        int N = 100000;
        drawStandard(N);
        //drawLogLog(N);
    }
}

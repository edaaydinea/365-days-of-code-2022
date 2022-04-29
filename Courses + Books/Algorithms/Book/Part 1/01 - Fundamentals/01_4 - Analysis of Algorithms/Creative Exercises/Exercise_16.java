import java.util.Arrays;
import java.util.Random;

public class Exercise_16 {
    public static Double[] closestPair(Double[] d) {
        Arrays.sort(d);
        int a = 0;
        int b = 1;
        double closest = Math.abs(d[a] - d[b]);
        for (int i = 2; i < d.length; i++) {
            double dist = Math.abs(d[i] - d[i - 1]);
            if (dist < closest) {
                a = i;
                b = i - 1;
                closest = dist;
            }
        }
        return new Double[]{d[a], d[b]};
    }

    public static void main(String[] args) {
        Random r = new Random();
        Double[] d = new Double[100];
        for (int i = 0; i < 100; i++) {
            d[i] = r.nextDouble();
        }
        System.out.println(Arrays.toString(closestPair(d)));
    }
}

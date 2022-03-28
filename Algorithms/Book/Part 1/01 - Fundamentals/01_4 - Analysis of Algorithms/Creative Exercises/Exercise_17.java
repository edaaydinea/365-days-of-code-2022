import java.util.Arrays;
import java.util.Random;

public class Exercise_17 {
    public static Double[] farthestPair(Double[] d) {
        int max = d[0] > d[1] ? 0 : 1;
        int min = d[0] > d[1] ? 1 : 0;
        for (int i = 2; i < d.length; i++) {
            if (d[i] > max) max = i;
            else if (d[i] < min) min = i;
        }
        return new Double[]{d[min], d[max]};
    }

    public static void main(String[] args) {
        Random r = new Random();
        Double[] d = new Double[100];
        for (int i = 0; i < 100; i++) {
            d[i] = r.nextDouble();
        }
        System.out.println(Arrays.toString(farthestPair(d)));
    }
}

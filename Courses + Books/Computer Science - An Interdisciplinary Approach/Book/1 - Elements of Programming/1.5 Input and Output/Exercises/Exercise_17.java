import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_17 {
    public static void main(String[] args) {
        final int FROM = -1;
        final int TO = 1;
        StdOut.printf("Enter sequence of #'s in range [%d, %d] (Ctrl-d to stop)\n", FROM, TO);

        double prevNumber = StdIn.readDouble();
        double absSum = Math.abs(prevNumber) > TO ? 0.0 : prevNumber;
        double squaresSum = Math.abs(prevNumber) > TO ? 0.0 : prevNumber * prevNumber;
        int zeroCrossings = 0;
        int numsCounter = 1;

        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            if (Math.abs(value) > TO) continue; // out of range values are skipped

            absSum += Math.abs(value);
            squaresSum += value * value;
            zeroCrossings += (prevNumber > 0 && value < 0 || prevNumber < 0 && value > 0) ? 1 : 0;
            numsCounter++;
            prevNumber = value;
        }

        StdOut.printf("average magnitude = %.3f\naverage power = %.3f\nzero crossings = %d",
                absSum / numsCounter, squaresSum / numsCounter, zeroCrossings);
    }
}

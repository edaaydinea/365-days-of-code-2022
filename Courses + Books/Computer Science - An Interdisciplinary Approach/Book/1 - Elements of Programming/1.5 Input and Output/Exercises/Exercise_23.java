import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdIn;

public class Exercise_23 {
    public static void main(String[] args) {
        double volume = Double.parseDouble(args[0]);
        double tempo = Double.parseDouble(args[1]);

        final int SAMPLING_RATE = 44100;
        final double NOTES = 12.0;
        final int CONCERT_A = 440;

        while (!StdIn.isEmpty()) { // Read and play one note.

            int pitch = StdIn.readInt();                   // read in the pitch, where 0 = Concert A (A4)
            double duration = StdIn.readDouble() * tempo;  // read in duration in seconds

            // build sine wave with desired frequency
            double hz = CONCERT_A * Math.pow(2, pitch / NOTES);
            int n = (int) (SAMPLING_RATE * duration);
            double[] a = new double[n + 1];
            for (int i = 0; i <= n; i++) {
                a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE) * volume;
            }

            StdAudio.play(a);
        }
    }
}

import edu.princeton.cs.algs4.StdAudio;

public class Exercise_24 {
    public static void main(String[] args) {
        String fileName = args[0];
        double r = Double.parseDouble(args[1]);

        double[] original = StdAudio.read(fileName);

        if (r == 1) StdAudio.play(original);
        else if (r < 1) {
            double[] b = new double[(int) (original.length * r) + 100];
            // TODO
            StdAudio.play(b);
        } else {
        }
    }
}

import edu.princeton.cs.algs4.StdOut;

public class StrictlyBetween {
    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println("Must pass 2 double arguments");
        } else {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);
            StdOut.println(x > 0 && x < 1 && y > 0 && y < 1);
        }
    }
}

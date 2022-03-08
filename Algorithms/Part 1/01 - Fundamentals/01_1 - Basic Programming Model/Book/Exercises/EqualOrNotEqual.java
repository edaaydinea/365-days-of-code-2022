import edu.princeton.cs.algs4.StdOut;

public class EqualOrNotEqual {

    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int n3 = Integer.parseInt(args[2]);

        StdOut.println(n1 == n2 && n2 == n3 ? "equal" : "not equal");
    }
}

public class RandomInt {
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double r = Math.random();
        int t = (int) (r * N);

        System.out.println(t);
    }
}

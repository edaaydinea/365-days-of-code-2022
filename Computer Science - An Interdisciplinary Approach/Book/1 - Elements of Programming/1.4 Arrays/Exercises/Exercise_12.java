public class Exercise_12 {
    public static void main(String[] args) {

        int n = args.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++)
            freq[i] = Integer.parseInt(args[i]);

        int total = 0;
        for (int i = 0; i < n; i++)
            total += freq[i];

        int r = (int) (total * Math.random());   // integer in [0, total)
        int sum = 0;
        int event = -1;
        for (int i = 0; i < n && sum <= r; i++) {
            sum += freq[i];
            event = i;
        }

        System.out.println(event);
    }
}

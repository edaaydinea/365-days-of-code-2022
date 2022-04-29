public class GaussianRandomNumbers {
    public static void main(String[] args) {
        double v = Math.random();
        double u = Math.random();

        double r = Math.sin(2 * Math.PI * v) * Math.sqrt(-2 * Math.log(u));
        System.out.println(r);
    }
}

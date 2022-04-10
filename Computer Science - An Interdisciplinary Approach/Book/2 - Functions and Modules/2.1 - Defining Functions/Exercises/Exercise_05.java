public class Exercise_05 {
    public static void main(String[] args) {
        double a = 1 + Math.random() * 100; // [1, 100]
        double b = 1 + Math.random() * 100;
        double c = 1 + Math.random() * 100;
    }

    public static boolean areTriangular(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}

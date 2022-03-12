public class PolarCoordinates {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        double radius = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);

        System.out.printf("Radius %f", radius);
        System.out.printf("Theta %f", theta);
    }
}

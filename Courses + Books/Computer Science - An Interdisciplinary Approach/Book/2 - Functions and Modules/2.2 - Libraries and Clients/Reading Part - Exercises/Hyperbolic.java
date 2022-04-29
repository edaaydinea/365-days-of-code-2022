public class Hyperbolic {
    public static double sinh(double x) {
        return (Math.exp(x) - Math.exp(-x)) / 2;
    }

    public static double cosh(double x) {
        return (Math.exp(x) + Math.exp(-x)) / 2;
    }

    public static double tanh(double x) { // avoid infinite / infinite
        return x >= 20 ? 1.0 : (x <= -20 ? -1.0 : sinh(x) / cosh(x));
    }

    public static double coth(double x) {
        return 1 / tanh(x);
    }

    public static double sech(double x) {
        return 1 / cosh(x);
    }

    public static double csch(double x) {
        return 1 / sinh(x);
    }
}
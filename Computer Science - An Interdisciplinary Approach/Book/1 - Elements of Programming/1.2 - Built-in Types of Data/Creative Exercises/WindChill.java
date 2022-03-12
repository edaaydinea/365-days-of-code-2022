public class WindChill {
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);     // degrees in Fahrenheit
        double v = Double.parseDouble(args[1]);     // wind speed in miles per hour
        double w = 35.74 + (0.6215 * T) + ((0.4275 * T) - 35.75) * Math.pow(v, 0.16);
    }
}

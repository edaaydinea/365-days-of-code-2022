public class ContinuouslyCompoundedInterest {
    public static void main(String[] args) {
        double p = Double.parseDouble(args[0]);     // invested dollars
        double t = Double.parseDouble(args[1]);     // time in years
        double r = Double.parseDouble(args[2]);     // annual interest rate

        System.out.println("Year\t Amount");
        for (int i = 0; i <= t; i++) {
            double amount = p * Math.pow(Math.E, r * i);
            System.out.println(i + "\t" + amount);
        }
    }
}

public class Sqrt
{
    public static void main (String[] args)
    {
        double EPS = 1E-15; // ERROR TOLERANCE (15 places)
        double c = Double.parseDouble(args[0]);
        double t = c;
        while (Math.abs(t-c / t) > t*EPS)
            t = (c/t + t) / 2.0;
        System.out.println(t);
    }
}

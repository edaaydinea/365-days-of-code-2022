public class ThreeSort
{
    public static void main(String[] args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (b<a)
        {
            int t = a; a = b; b = t;
        }
        if (c<a)
        {
            int t = a; a = c; c = t;
        }
        if (c<b)
        {
            int t = b; b = c; c = t;
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

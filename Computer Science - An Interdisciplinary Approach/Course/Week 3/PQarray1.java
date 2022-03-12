public class PQarray1
{
    public static void main(String[] args)
    {
        int[] a = new int[6];
        int[] b = new int[a.length];

        b = a;
        for (int i = 1; i< b.length; i++)
            b[i] = i;

        for (int i = 0; i< a.length; i++)
            System.out.println(a[i] + " ");

        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println();
    }
}
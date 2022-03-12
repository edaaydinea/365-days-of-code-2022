public class ColorConversion {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[0]);

        double w = Math.max((double) r / 255,
                Math.max((double) g / 255, (double) b / 255));
        double c, m, y, k;
        if (r == 0 && g == 0 && b == 0 || w == 0) {
            c = 0;
            m = 0;
            y = 0;
            k = 1;
        } else {
            c = (w - (r / 255)) / w;
            m = (w - (g / 255)) / w;
            y = (w - (b / 255)) / w;
            k = 1 - w;
        }

        System.out.println("cyan    = " + c);
        System.out.println("magenta = " + m);
        System.out.println("yellow  = " + y);
        System.out.println("black   = " + k);


    }
}

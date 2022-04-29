/******************************************************************************
 *  Converts from CMYK format to RGB format
 *
 *
 *  Compilation:  javac CMYKtoRGB.java
 *  Execution:    java CMYKtoRGB  0.0 1.0 0.0 0.0
 *
 *	 ~/Desktop/hello> java CMYKtoRGB 0.0 1.0 0.0 0.0    // magenta
 *		red   = 255
 *		green = 0
 *		blue  = 255
 *
 *	~/Desktop/hello> java CMYKtoRGB 0.0 0.4392156862745098 1.0 0.0    // Princeton orange
 *		red   = 255
 *		green = 143
 *		blue  = 0

 *  Converts from CMYK format to RGB format
 *
 ******************************************************************************/

public class CMYKtoRGB {
    public static void main (String[] args)
    {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        double white = 1- black;
        int red = (int) Math.round(255 * white * (1- cyan));
        int green = (int) Math.round(255 * white * (1- magenta));
        int blue = (int) Math.round(255 * white * (1 - yellow));

        System.out.println("red = "+ red);
        System.out.println("green= "+ green);
        System.out.println("blue= " + blue);
    }
}

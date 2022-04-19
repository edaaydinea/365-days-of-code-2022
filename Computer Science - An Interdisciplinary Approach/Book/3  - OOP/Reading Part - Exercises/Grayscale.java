/******************************************************************************
 *  Compilation:  javac Grayscale.java
 *  Execution:    java Grayscale filename
 *  Data files:   <a href="https://introcs.cs.princeton.edu/java/31datatype/mandrill.jpg">https://introcs.cs.princeton.edu/java/31datatype/mandrill.jpg</a>
 *                <a href="https://introcs.cs.princeton.edu/java/31datatype/darwin.jpg">https://introcs.cs.princeton.edu/java/31datatype/darwin.jpg</a>
 *
 *  Reads in an image from a file, converts it to grayscale, and
 *  displays it on the screen.
 *
 *  % java Grayscale image.jpg
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class Grayscale {

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        int width  = picture.width();
        int height = picture.height();

        // convert to grayscale
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                Color gray = Luminance.toGray(color);
                picture.set(col, row, gray);
            }
        }
        picture.show();
    }

}
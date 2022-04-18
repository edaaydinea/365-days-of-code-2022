/******************************************************************************
 *  Compilation:  javac-introcs Scale.java
 *  Execution:    java-introcs Scale filename w h
 *  Data files:   <a href="https://introcs.cs.princeton.edu/java/31datatype/mandrill.jpg">https://introcs.cs.princeton.edu/java/31datatype/mandrill.jpg</a>
 *
 *  Scales an image to w-by-h and displays both the original
 *  and the scaled version to the screen.
 *
 *  % java-introcs Scale mandrill.jpg 200 300
 *
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class Scale {
    public static void main(String[] args) {
        String filename = args[0];
        int width  = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        Picture source = new Picture(filename);
        Picture target = new Picture(width, height);

        for (int targetCol = 0; targetCol < width; targetCol++) {
            for (int targetRow = 0; targetRow < height; targetRow++) {
                int sourceCol = targetCol * source.width()  / width;
                int sourceRow = targetRow * source.height() / height;
                Color color = source.get(sourceCol, sourceRow);
                target.set(targetCol, targetRow, color);
            }
        }

        source.show();
        target.show();
    }
}
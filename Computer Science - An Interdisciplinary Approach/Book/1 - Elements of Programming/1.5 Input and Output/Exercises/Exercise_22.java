import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class Exercise_22 {
    public static void main(String[] args) {
        String s = args[0];
        int speed = Integer.parseInt(args[1]); // lower values => smoother movement

        // Set text properties
        StdDraw.setFont(new Font(Font.MONOSPACED, Font.BOLD, 60));
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.enableDoubleBuffering();

        //  We can produce animations by repeating the following four steps:
        //    Clear the offscreen canvas.
        //    Draw objects on the offscreen canvas.
        //    Copy the offscreen canvas to the onscreen canvas.
        //    Wait for a short while.
        for (double p = 0; true; p += 0.01) {
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.text(p % 1.0, 0.5, s);
            StdDraw.text(p % 1.0 - 1.0, 0.5, s); // wrapping to the beginning
            StdDraw.text(p % 1.0 + 1.0, 0.5, s); // wrapping to the beginning
            StdDraw.show();
            StdDraw.pause(speed);
        }

    }
}

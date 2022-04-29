import edu.princeton.cs.algs4.StdDraw;

/*
   Program 1.5.6 Bouncing ball
 */
public class BouncingBall {
    public static void main(String[] args) {
        // Simulate the motion of a bouncing ball.
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();
        double rx = 0.480, ry = 0.860;
        double vx = 0.015, vy = 0.023;
        double radius = 0.05;
        while(true) {
            // Update ball position and draw it.
            if (Math.abs(rx + vx) + radius > 1.0)
                vx = -vx;
            if (Math.abs(ry + vy) + radius > 1.0)
                vy = -vy;
            rx += vx;
            ry += vy;
        StdDraw.clear();
        StdDraw.filledCircle(rx, ry, radius);
        StdDraw.show(); StdDraw.pause(20);
    } } }

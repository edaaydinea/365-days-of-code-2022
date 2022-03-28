import java.util.Scanner;

public class RandomWalk2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();

        int x = 0;
        int y = 0;
        System.out.println("(" + x + ", " + y + ")");


        int rdo = 0;
        int steps = 0;
        while (rdo != r) {
            double z = Math.random();
            if (z <= 0.25) {
                x += 1;
            } else if (z <= 0.5) {
                x -= 1;
            } else if (z < 0.75) {
                y += 1;
            } else {
                y -= 1;
            }
            rdo = Math.abs(x) + Math.abs(y);
            System.out.println("(" + x + ", " + y + ")");

            steps += 1;
        }
        System.out.println("steps = " + steps);


    }
}

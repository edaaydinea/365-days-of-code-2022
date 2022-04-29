public class Ramanujan {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);

        if (isRamanujansNumber(num))
            System.out.printf("This number (%d) is a Ramanujan's number.", num);
        else
            System.out.printf("This number (%d) is not a Ramanujan's number.", num);
    }

    public static boolean isRamanujansNumber(int num) {
        int result = 0;
        for (int i = 1; i <= (num - 1) / (i * i); i++) {
            for (int j = i; j <= (num - 1) / (j * i); j++) {
                boolean test = Math.pow(i, 3) + Math.pow(j, 3) == num;
                if (test) {
                    result += 1;
                    System.out.printf("( %d , %d ) = Sum = % d \n",
                            (int) Math.pow(i, 3),
                            (int) Math.pow(j, 3),
                            (int) Math.pow(i, 3) + (int) Math.pow(j, 3));
                }
            }
        }
        return result == 2;
    }
}

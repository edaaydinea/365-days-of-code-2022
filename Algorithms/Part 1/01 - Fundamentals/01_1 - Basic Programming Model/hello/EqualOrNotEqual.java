import java.util.Scanner;

public class EqualOrNotEqual {
    private static String equalOrNotEqual(int first_number, int second_number, int third_number) {

        String firstnumber = String.valueOf(first_number);
        String secondnumber = String.valueOf(second_number);
        String thirdnumber = String.valueOf(third_number);

        if (firstnumber.equals(secondnumber)) {
            if (secondnumber.equals(thirdnumber)) {
                return "equal";
            }
        } else
            return "not equal";

        return "No numbers founds";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first_number = scanner.nextInt();
        int second_number = scanner.nextInt();
        int third_number = scanner.nextInt();

        String result = equalOrNotEqual(first_number, second_number, third_number);

        System.out.println(result);
    }
}

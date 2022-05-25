import java.util.Scanner;

public class SignUp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to JavaGram! Let's sign you up.");

        System.out.println("What is your first name?");
        String firstName = scanner.nextLine();

        System.out.println("What is your last name?");
        String lastName = scanner.nextLine();

        System.out.println("How old are you?");
        int age = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Make a username");
        String userName = scanner.nextLine();

        System.out.println("What city do you live in?");
        String city = scanner.nextLine();

        System.out.println("What country is that?");
        String country = scanner.nextLine();

        System.out.println("Thank you for joining JavaGram!");
        System.out.println("\nHere is the information you entered:");
        System.out.println("\tFirst Name: " + firstName);
        System.out.println("\tLast Name: " + lastName);
        System.out.println("\tAge: " + age);
        System.out.println("\tUsername: " + userName);
        System.out.println("\tCity: " + city);
        System.out.println("\tCountry: " + country);

        scanner.close();

    }
}

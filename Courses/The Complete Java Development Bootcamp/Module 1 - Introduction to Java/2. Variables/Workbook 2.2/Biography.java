import java.util.Scanner;

public class Biography {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //make a name variable
        System.out.println("Enter your name: ");
        String name = scanner.next();
        //make an age variable
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        //make a country variable
        System.out.println("Enter the country where you come from: ");
        String country = scanner.next();
        //make a sport variable
        System.out.println("Enter your favourite sport name: ");
        String sport = scanner.next();
        //make an hours variable
        System.out.println("Enter the number of hours you do this sport per day: ");
        int hours = scanner.nextInt();
        //make a game variable
        System.out.println("Enter the game name: ");
        String game = scanner.next();
        //make a subject variable
        System.out.println("Enter the your favourite subject: ");
        String subject = scanner.next();
        //make a grade variable
        System.out.println("Enter your grade in this subject: ");
        int grade = scanner.nextInt();

        System.out.println("My name is " + name + ". I'm <age> years old, and I'm from <country> ");
        System.out.println("My favourite sport is <sport>. I play for <hours> hours a day");
        System.out.println("When I'm tired, I like to play <game>.");
        System.out.println("In school, my favourite subject was <subject>, I scored a <grade>.");

    }
}
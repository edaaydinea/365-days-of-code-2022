public class UniformRandomNumbers {
    public static void main(String[] args) {
        double number1 = Math.random();
        double number2 = Math.random();
        double number3 = Math.random();
        double number4 = Math.random();
        double number5 = Math.random();

        double sum = number1 + number2 + number3 + number4 + number5;

        System.out.println("1st number: " + number1);
        System.out.println("2nd number: " + number2);
        System.out.println("3rd number: " + number3);
        System.out.println("4th number: " + number4);
        System.out.println("5th number: " + number5);
        System.out.println("Average: " + sum / 5);
        System.out.println("Min: " + Math.min(number1, Math.min(Math.min(number2, number3), Math.min(number4, number5))));
        System.out.println("Max: " + Math.max(number1, Math.max(Math.max(number2, number3), Math.max(number4, number5))));
    }
}

import java.util.concurrent.TimeUnit;

public class Exercise_05 {
    public static void main(String[] args) {
        long numOf_Iterations_Per_Union = (long) Math.pow(10, 9);
        long numberOf_Unions = (long) Math.pow(10, 6);
        long numberOf_Union_Iterations = numOf_Iterations_Per_Union * numberOf_Unions;
        long numberOf_Union_Instructions = 10 * numberOf_Union_Iterations;

        long total_number_of_seconds = numberOf_Union_Instructions / numOf_Iterations_Per_Union;

        int day = (int) TimeUnit.SECONDS.toDays(total_number_of_seconds);

        System.out.printf("Number of iterations per union: %d \n", numOf_Iterations_Per_Union);
        System.out.printf("Number of union: %d \n", numberOf_Unions);
        System.out.printf("Number of union iterations: %d \n", numberOf_Union_Iterations);
        System.out.printf("Number of union instructions: %d \n", numberOf_Union_Instructions);
        System.out.printf("Total number of seconds: %d - days: %d \n", total_number_of_seconds, day);
    }
}

import java.util.concurrent.TimeUnit;

public class Exercise_06 {
    public static void main(String[] args) {
        long numOf_Iterations_Per_Union = (long) ((long) 2 * Math.log10(Math.pow(10, 6)));
        long numberOf_Unions = (long) Math.pow(10, 6);
        long numberOf_Union_Iterations = numberOf_Unions * numOf_Iterations_Per_Union;
        long numberOf_Union_Instructions = (long) (2 * Math.pow(10, 7) * numOf_Iterations_Per_Union);

        long total_number_of_seconds = (long) (numberOf_Union_Instructions / Math.pow(10, 9));

        int day = (int) TimeUnit.SECONDS.toDays(total_number_of_seconds);

        System.out.printf("Number of iterations per union: %d \n", numOf_Iterations_Per_Union);
        System.out.printf("Number of union: %d \n", numberOf_Unions);
        System.out.printf("Number of union iterations: %d \n", numberOf_Union_Iterations);
        System.out.printf("Number of union instructions: %d \n", numberOf_Union_Instructions);
        System.out.printf("Total number of seconds: %d - days: %d \n", total_number_of_seconds, day);
    }
}


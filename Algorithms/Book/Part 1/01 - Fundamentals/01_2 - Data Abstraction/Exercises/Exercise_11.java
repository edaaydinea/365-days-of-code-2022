import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_11 {
    public record SmartDate(int month, int day, int year) {
        private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public SmartDate {
            if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public int getYear() {
            return year;
        }

        private static boolean isValid(int m, int d, int y) {
            if (m < 1 || m > 12) return false;
            if (d < 1 || d > DAYS[m]) return false;
            if (m == 2 && d == 29 && !isLeapYear(y)) return false;
            return true;
        }

        private static boolean isLeapYear(int y) {
            if (y % 400 == 0) return true;
            if (y % 100 == 0) return false;
            return y % 4 == 0;
        }

        public String toString() {
            return getMonth() + "/" + getDay() + "/" + getYear();
        }
    }

    public static void main(String[] args) {
        StdOut.print("Enter the date as month day year: ");
        int month = StdIn.readInt();
        int day = StdIn.readInt();
        int year = StdIn.readInt();
        SmartDate smartDate = new SmartDate(month, day, year);
        System.out.println(smartDate);
    }
}

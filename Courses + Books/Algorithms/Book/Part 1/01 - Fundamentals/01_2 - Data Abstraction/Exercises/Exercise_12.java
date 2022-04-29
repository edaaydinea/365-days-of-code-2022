import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_12 {
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

        public String dayOfWeek() {

            int day = this.getDay();
            int month = this.getMonth();
            int year = this.getYear();

            if (month < 3) {
                month += 12;
                year--;
            }
            int w = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;

            String[] dayOfWeek = {"Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday",
                    "Saturday",
                    "Sunday"};
            return dayOfWeek[w];

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
        String s = smartDate.dayOfWeek();
        System.out.println(s);
    }
}

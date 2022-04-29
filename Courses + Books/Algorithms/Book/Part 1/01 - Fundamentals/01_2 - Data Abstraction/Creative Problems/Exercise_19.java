public class Exercise_19 {
    public static class Transaction {
        private final String Customer;
        private final Date Date;
        private final double Money;

        public Transaction(String information) {
            String[] words = information.split(" ");
            Customer = words[0];
            Date = new Date(words[1]);
            Money = Double.parseDouble(words[2]);
        }

        @Override
        public String toString() {
            return "Customer：" + Customer + " Date：" + Date + " Money：" + Money;
        }
    }

    public static class Date {
        private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        private final int month;   // month (between 1 and 12)
        private final int day;     // day   (between 1 and DAYS[month]
        private final int year;    // year

        public Date(String date) {
            String[] fields = date.split("/");
            if (fields.length != 3) {
                throw new IllegalArgumentException("Invalid date");
            }
            month = Integer.parseInt(fields[0]);
            day = Integer.parseInt(fields[1]);
            year = Integer.parseInt(fields[2]);
            if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
        }

        private static boolean isValid(int month, int day, int year) {
            if (month < 1 || month > 12) return false;
            if (day < 1 || day > DAYS[month]) return false;
            return month != 2 || day != 29 || isLeapYear(year);
        }

        private static boolean isLeapYear(int year) {
            if (year % 400 == 0) return true;
            if (year % 100 == 0) return false;
            return year % 4 == 0;
        }

        @Override
        public String toString() {
            return "year：" + year + " month：" + month + " day：" + day;
        }
    }

    public static void main(String[] args) {
        Date date = new Date("5/22/1939");
        Transaction transaction = new Transaction("Turing 5/22/1939 11.99");
        System.out.println(date);
        System.out.println(transaction);
    }
}

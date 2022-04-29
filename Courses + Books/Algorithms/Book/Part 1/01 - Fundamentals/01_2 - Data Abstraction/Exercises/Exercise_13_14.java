import edu.princeton.cs.algs4.Date;

import java.util.Objects;

public class Exercise_13_14 {
    public static class Transaction {
        private final String Customer;
        private final Date Date;
        private final double Money;

        public Transaction(String customer, edu.princeton.cs.algs4.Date date, double money) {
            Customer = customer;
            Date = date;
            Money = money;
        }

        public String getCustomer() {
            return Customer;
        }

        public edu.princeton.cs.algs4.Date getDate() {
            return Date;
        }

        public double getMoney() {
            return Money;
        }

        @Override
        public String toString() {
            return getCustomer() + " " + getDate() + " " + getMoney();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null) return false;
            if (obj.getClass() != this.getClass()) return false;
            Transaction that = (Transaction) obj;
            return (Objects.equals(this.Customer, that.Customer)) && (this.Date == that.Date) && (this.Money == that.Money);
        }
    }

    public static void main(String[] args) {
        Date date = new Date(7, 26, 2018);
        Transaction transaction = new Transaction("mereder", date, 11.12);
        Transaction test = new Transaction("jiaojiao", date, 11.12);
        Transaction test2 = new Transaction("mereder", date, 11.12);
        if (test.equals(transaction)) System.out.println("true");
        else System.out.println("false");
        if (test2.equals(transaction)) System.out.println("true");
        else System.out.println("false");
        System.out.println(transaction);
    }
}

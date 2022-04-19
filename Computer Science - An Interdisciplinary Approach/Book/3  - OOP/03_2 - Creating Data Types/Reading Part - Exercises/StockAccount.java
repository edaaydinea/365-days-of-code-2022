/******************************************************************************
 *  Compilation:  javac StockAccount.java
 *  Execution:    java StockAccount input.txt
 *  Dependencies: In.java StdOut.java StockQuote.java
 *  Data files:   https://introcs.cs.princeton.edu/java/32class/Turing.txt
 *
 *  % more Turing.txt
 *  Turing, Alan
 *  10.24
 *  5
 *  100 ADBE
 *   25 GOOG
 *  97 IBM
 *  250 MSFT
 *  200 YHOO
 *
 *  % java StockAccount Turing.txt
 *  Turing, Alan
 *                   Cash: $    10.24
 *   100  ADBE   $ 40.62   $  4062.00
 *    25  GOOG   $500.03   $ 12500.75
 *    97   IBM   $117.35   $ 11382.95
 *   250  MSFT   $ 29.71   $  7427.50
 *   200  YHOO   $ 23.80   $  4760.00
 *                  Total: $ 40143.44
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.*;

public class StockAccount {
    private final String name;     // customer name
    private double cash;           // cash balance
    private int n;                 // number of stocks in portfolio
    private int[] shares;          // shares[i] = number of shares of stock i
    private String[] stocks;       // stocks[i] = symbol of stock i

    // build data structure from file
    public StockAccount(String filename) {
        In in = new In(filename);
        name = in.readLine();
        cash = in.readDouble();
        n = in.readInt();
        shares = new int[n];
        stocks = new String[n];
        for (int i = 0; i < n; i++) {
            shares[i] = in.readInt();
            stocks[i] = in.readString();
        }
    }

    // print a report to standard output
    public void printReport() {
        StdOut.println(name);
        double total = cash;
        for (int i = 0; i < n; i++) {
            int amount = shares[i];
            double price = StockQuote.priceOf(stocks[i]);
            total += amount * price;
            StdOut.printf("%4d %5s ", amount, stocks[i]);
            StdOut.printf("%9.2f %11.2f\n", price, amount * price);
        }
        StdOut.printf("%21s %10.2f\n", "Cash: ", cash);
        StdOut.printf("%21s %10.2f\n", "Total:", total);
    }

    // value of account
    public double valueOf() {
        StdOut.println(name);
        double total = cash;
        for (int i = 0; i < n; i++) {
            int amount = shares[i];
            double price = StockQuote.priceOf(stocks[i]);
            total += amount * price;
        }
        return total;
    }


    // test client
    public static void main(String[] args) {
        String filename = args[0];
        StockAccount account = new StockAccount(filename);
        account.printReport();
    }
}
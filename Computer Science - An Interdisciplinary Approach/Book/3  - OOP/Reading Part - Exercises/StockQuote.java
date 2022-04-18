import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac StockQuote.java
 *  Execution:    java StockQuote symbol
 *  Dependencies: In.java, StdOut.java
 *
 *  Print the stock price of the stock with the given symbol.
 *  Screen scrapes <a href="http://finance.yahoo.com">http://finance.yahoo.com</a> to get the current price
 *  and associated information.
 *
 *  Warning: if Yahoo updates the format of their page,
 *           this program also needs to be updated.
 *
 *  % java StockQuote GOOG
 *  744.0
 *  Alphabet Inc.
 *  Wed Jul 27 12:19:16 PDT 2016 
 *
 *  % java StockQuote AAPL
 *  103.78
 *  Apple Inc.
 *  Wed Jul 27 12:19:21 PDT 2016 
 *
 *  % java StockQuote IBM
 *  162.29
 *  International Business Machines Corporation
 *  Wed Jul 27 12:19:26 PDT 2016 
 *
 *  % java StockQuote MSFT
 *  56.46
 *  Microsoft Corporation
 *  Wed Jul 27 12:19:30 PDT 2016 
 *
 ******************************************************************************/

public class StockQuote {

    // Given symbol, get HTML
    private static String readHTML(String symbol) {
        In page = new In("http://finance.yahoo.com/quote/" + symbol);
        String html = page.readAll();
        if (html.contains("<title></title>")) return null;
        else return html;
    }

    // Given symbol, get current stock price.
    public static double priceOf(String symbol) {
        String html = readHTML(symbol);
        int p     = html.indexOf("price.0");      // "price.0" index
        int from  = html.indexOf(">", p);            // ">" index
        int to    = html.indexOf("</span>", from);   // "</span>" index
        String price = html.substring(from + 1, to);

        // remove any comma separators
        return Double.parseDouble(price.replaceAll(",", ""));
    }

    // Given symbol, get current stock price.
    public static double priceOf(String symbol, String html) {
        int p     = html.indexOf("price.0");      // "price.0" index
        int from  = html.indexOf(">", p);            // ">" index
        int to    = html.indexOf("</span>", from);   // "</span>" index
        String price = html.substring(from + 1, to);

        // remove any comma separators
        return Double.parseDouble(price.replaceAll(",", ""));
    }

    // Given symbol, get current stock name.
    public static String nameOf(String symbol, String html) {
        int p    = html.indexOf("symbol.$companyName");
        int from = html.indexOf(">", p);
        int to   = html.indexOf("</h6>", from);
        String name = html.substring(from + 1, to);
        return name;
    }

    // Given symbol, get current date.
    public static String dateOf(String symbol, String html) {
        int p    = html.indexOf("adx.bf1.yahoo.com");
        int from = html.indexOf(" ", p);
        int to   = html.indexOf("-->", from);
        String date = html.substring(from + 1, to);
        return date;
    }


    public static void main(String[] args) {
        String symbol = args[0];
        String html = readHTML(symbol);
        if (html == null) StdOut.println("Invalid symbol: " + symbol);
        else {
            StdOut.println(priceOf(symbol, html));
            StdOut.println(nameOf(symbol, html));
            StdOut.println(dateOf(symbol, html));
        }
    }

}
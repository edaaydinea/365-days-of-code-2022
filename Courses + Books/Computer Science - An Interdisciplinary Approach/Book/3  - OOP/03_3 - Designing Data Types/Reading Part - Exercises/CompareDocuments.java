/******************************************************************************
 *  Compilation:  javac CompareDocuments.java
 *  Execution:    java CompareDocuments 5 10000 < documents.txt
 *  Data files:   https://introcs.cs.princeton.edu/java/33design/documents.txt
 *                https://introcs.cs.princeton.edu/java/33design/Constitution.txt
 *                https://introcs.cs.princeton.edu/java/33design/TomSawyer.txt
 *                https://introcs.cs.princeton.edu/java/33design/HuckFin.txt
 *                https://introcs.cs.princeton.edu/java/33design/Prejudice.txt
 *                https://introcs.cs.princeton.edu/java/33design/Picture.java.txt
 *                https://introcs.cs.princeton.edu/java/33design/DJIA.csv
 *                https://introcs.cs.princeton.edu/java/33design/Amazon.html
 *                https://introcs.cs.princeton.edu/java/33design/ATCG.txt
 *
 *  % java CompareDocuments 5 10000 < documents.txt 
 *          Cons    TomS    Huck    Prej    Pict    DJIA    Amaz    ATCG
 *  Cons    1.00    0.66    0.60    0.64    0.20    0.18    0.21    0.11
 *  TomS    0.66    1.00    0.93    0.88    0.12    0.24    0.18    0.14
 *  Huck    0.60    0.93    1.00    0.82    0.09    0.23    0.16    0.12
 *  Prej    0.64    0.88    0.82    1.00    0.12    0.25    0.19    0.15
 *  Pict    0.20    0.12    0.09    0.12    1.00    0.05    0.39    0.03
 *  DJIA    0.18    0.24    0.23    0.25    0.05    1.00    0.16    0.11
 *  Amaz    0.21    0.18    0.16    0.19    0.39    0.16    1.00    0.07
 *
 ******************************************************************************/

public class CompareDocuments {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        String[] filenames = StdIn.readAllStrings();
        int n = filenames.length;

        // create document sketches
        Sketch[] sketches = new Sketch[n];
        for (int i = 0; i < n; i++) {
            In in = new In(filenames[i]);
            String text = in.readAll();
            sketches[i] = new Sketch(text, k, d);
        }
       
        // print header
        StdOut.print("    ");
        for (int i = 0; i < n; i++) {
            StdOut.printf("%8.4s", filenames[i]);
        }
        StdOut.println();

        // print n-by-n table
        for (int i = 0; i < n; i++) {
            StdOut.printf("%.4s", filenames[i]);
            for (int j = 0; j < n; j++) {
                StdOut.printf("%8.2f", sketches[i].similarTo(sketches[j]));
            }
            StdOut.println();
        }
    }
}

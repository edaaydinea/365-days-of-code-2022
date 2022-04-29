/******************************************************************************
 *  Compilation:  javac IndexGraph.java
 *  Dependencies: Graph.java In.java
 *  Execution:    java IndexGraph movies.txt "/"
 *  Data files:   https://introcs.cs.princeton.edu/java/45graph/tinyGraph.txt
 *                https://introcs.cs.princeton.edu/java/45graph/movies.txt
 *                https://introcs.cs.princeton.edu/java/45graph/amino.csv
 *  
 *  Builds a graph, then accepts vertex names from standard input
 *  and prints its neighbors.
 *
 *  % java IndexGraph tinyGraph.txt " "
 *  C
 *    A
 *    B
 *    G
 *  A
 *    B
 *    C
 *    G
 *    H
 *
 ******************************************************************************/

public class IndexGraph {

    public static void main(String[] args) {

        // read in the graph from a file
        String filename = args[0];
        String delimiter = args[1];
        Graph G = new Graph(filename, delimiter);

        // read a vertex and print its neighbors
        while (!StdIn.isEmpty()) {
            String v = StdIn.readLine();
            if (G.hasVertex(v)) {
                for (String w : G.adjacentTo(v)) {
                    StdOut.println("  " + w);
                }
            }
        }
    }

}

/******************************************************************************
 *  Compilation:  javac SmallWorld.java
 *  Execution:    java SmallWorld filename delimiter
 *  Dependencies: Graph.java PathFinder.java StdOut.java In.java
 *  Data files:   https://introcs.cs.princeton.edu/java/45graph/tinyGraph.txt
 *
 *  %  java SmallWorld tinyGraph.txt " "
 *  number of vertices     =       5
 *  number of edges        =       7
 *  average degree         =   2.800
 *  maximum degree         =       4
 *  average degree         =   2.800
 *  average path length    =   1.300
 *  clustering coefficient =   0.767
 *
 ******************************************************************************/

public class SmallWorld {

    public static double averageDegree(Graph G) {
        return (double) 2 * G.E() / G.V();
    }

    public static double averagePathLength(Graph G) {
        int sum = 0;
        for (String v : G.vertices()) {
            PathFinder pf = new PathFinder(G, v);
            for (String w : G.vertices())
                sum += pf.distanceTo(w);
        }
        return (double) sum / (G.V() * (G.V() - 1));
    }


    // Compute clustering coefficient.
    public static double clusteringCoefficient(Graph G) {
        double total = 0.0;
        for (String v : G.vertices()) {
            // Cumulate local clustering coefficient of vertex v.
            int possible = G.degree(v) * (G.degree(v) - 1);
            int actual = 0;
            for (String u : G.adjacentTo(v)) {
                for (String w : G.adjacentTo(v)) {
                    if (G.hasEdge(u, w))
                        actual++;
                }
            }
            if (possible > 0) {
                total += 1.0 * actual / possible;
            }
        }
        return total / G.V();
    }

    // return maximum degree of any vertex
    public static int maxDegree(Graph G) {
        int max = 0;
        for (String v : G.vertices()) {
            if (G.degree(v) > max)
                max = G.degree(v);
        }
        return max;
    }

    public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        Graph graph = new Graph(filename, delimiter);

        StdOut.printf("number of vertices     = %7d\n", graph.V());
        StdOut.printf("number of edges        = %7d\n", graph.E());
        StdOut.printf("average degree         = %7.3f\n", averageDegree(graph));
        StdOut.printf("maximum degree         = %7d\n",   maxDegree(graph));
        StdOut.printf("average path length    = %7.3f\n", averagePathLength(graph));
        StdOut.printf("clustering coefficient = %7.3f\n", clusteringCoefficient(graph));

    }

}

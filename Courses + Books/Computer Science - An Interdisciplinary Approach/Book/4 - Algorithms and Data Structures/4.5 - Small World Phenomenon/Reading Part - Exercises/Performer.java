/******************************************************************************
 *  Compilation:  javac SmallWorld.java
 *  Execution:    java SmallWorld filename delimiter
 *  Dependencies: Graph.java PathFinder.java StdOut.java In.java
 *  Data files:   https://introcs.cs.princeton.edu/java/45graph/tinyMovies.txt
 *                https://introcs.cs.princeton.edu/java/45graph/moviesG.txt
 *
 *  % java Performer tinyMovies.txt "/"
 *  number of vertices     =       5
 *  average degree         =   2.800
 *  average path length    =   1.300
 *  clustering coefficient =   0.767
 *
 *  % java Performer moviesG.txt "/"
 *  [ after a long time ]
 *  number of vertices     =   19044
 *  average degree         = 148.688
 *  average path length    =   3.494
 *  clustering coefficient =   0.911
 *
 ******************************************************************************/

public class Performer {

    public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        Graph graph = new Graph();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                for (int j = i+1; j < names.length; j++) {
                    graph.addEdge(names[i], names[j]);
                }
            }
        }

        double degree  = SmallWorld.averageDegree(graph);
        double length  = SmallWorld.averagePathLength(graph);
        double cluster = SmallWorld.clusteringCoefficient(graph);
        StdOut.printf("number of vertices     = %7d\n", graph.V());
        StdOut.printf("average degree         = %7.3f\n", degree);
        StdOut.printf("average path length    = %7.3f\n", length);
        StdOut.printf("clustering coefficient = %7.3f\n", cluster);
    }
}

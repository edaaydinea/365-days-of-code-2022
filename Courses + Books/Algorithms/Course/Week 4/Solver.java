import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Solving Slider Puzzle using A* algorithm with Manhattan priority function!
 */
public class Solver {

    private final Board initial;
    private final Iterable<Board> solution;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Initial board can not be null!");
        }
        this.initial = initial;
        solution = solution();
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);


        System.out.println(initial);
        System.out.println("Dimension of board : " + initial.dimension());
        System.out.println("Manhattan of board : " + initial.manhattan());
        System.out.println("Is Goal Board? : " + initial.isGoal());

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return solution != null;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return solution == null ? -1 : ((Collection<?>) solution).size() - 1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (initial.isGoal()) {
            return new ArrayList<>(){{add(initial);}};
        }
        Board twin = initial.twin();

        SearchNode initialNode = new SearchNode(initial, 0, null);
        SearchNode twinNode = new SearchNode(twin, 0, null);

        boolean reachedGoalInitial = false;
        List<SearchNode> stackInitial = new ArrayList<>();
        MinPQ<SearchNode> minPQInitial = new MinPQ<>();
        minPQInitial.insert(initialNode);

        boolean reachedGoalTwin = false;
        List<SearchNode> stackTwin = new ArrayList<>();
        MinPQ<SearchNode> minPQTwin = new MinPQ<>();
        minPQTwin.insert(twinNode);


        boolean isTwinTurn = false;
        while (!reachedGoalInitial && !reachedGoalTwin) {
            if (isTwinTurn) {
                SearchNode current = minPQTwin.delMin();
                if (current.getBoard().isGoal()) {
                    stackTwin.add(current);
                    reachedGoalTwin = true;
                } else {
                    stackTwin.add(current);
                    Iterable<Board> neighbors = current.getBoard().neighbors();
                    for (Board neighbor : neighbors) {
                        SearchNode searchNodeNeighbor = new SearchNode(neighbor, current.moves + 1, current);
                        if (!searchNodeNeighbor.equals(current.parent)) {
                            minPQTwin.insert(searchNodeNeighbor);
                        }
                    }
                }
                isTwinTurn = false;
            } else {
                SearchNode current = minPQInitial.delMin();
                if (current.board.isGoal()) {
                    stackInitial.add(current);
                    reachedGoalInitial = true;
                } else {
                    stackInitial.add(current);
                    Iterable<Board> neighbors = current.getBoard().neighbors();
                    for (Board neighbor : neighbors) {
                        SearchNode searchNodeNeighbor = new SearchNode(neighbor, current.moves + 1, current);
                        if (!searchNodeNeighbor.equals(current.parent)) {
                            minPQInitial.insert(searchNodeNeighbor);
                        }
                    }
                }
                isTwinTurn = true;
            }
        }

        if (reachedGoalTwin) {
            return null;
        }

        if (reachedGoalInitial) {
            List<Board> pathToGoal = new ArrayList<>();
            SearchNode current = stackInitial.get(stackInitial.size() - 1);
            while (current != null) {
                pathToGoal.add(current.getBoard());
                current = current.parent;
            }
            Collections.reverse(pathToGoal);
            return pathToGoal;
        }
        return null;
    }

    private class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private SearchNode parent = null;
        private final int moves;
        private final int priority;

        public SearchNode(Board board, int moves, SearchNode parent) {
            this.board = board;
            this.moves = moves;
            this.parent = parent;
            this.priority = this.moves + this.board.manhattan();
        }

        public boolean equals(SearchNode searchNode) {
            if(searchNode == null){
                return false;
            }
            return this.board.equals(searchNode.board);
        }

        public Board getBoard() {
            return this.board;
        }

        @Override
        public int compareTo(SearchNode o) {
            return this.priority - o.priority;
        }
    }

}
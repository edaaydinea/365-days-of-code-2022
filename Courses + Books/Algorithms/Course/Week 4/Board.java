import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private final int[][] board;
    private int manhattan = -1;
    private int hamming = -1;
    private Board twin;
    private boolean isGoalBoard;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles){
        board = clone(tiles);
        this.manhattan = manhattan();
        this.hamming = hamming();
        twin = null;
        isGoalBoard = isGoal();
    }

    // string representation of this board
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(board.length+"\n");
        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension(){
        return board.length;
    }

    // number of tiles out of place
    public int hamming(){
        if(hamming >= 0){
            return hamming;
        }

        int hamming = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                int pos = i * board.length + j + 1;
                if(board[i][j] != 0 && board[i][j] != pos){
                    hamming++;
                }
            }
        }
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan(){
        if(manhattan >= 0){
            return manhattan;
        }

        int manhattan = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                if(board[i][j] != 0){
                    int num = board[i][j] - 1;
                    int row = num / board.length;
                    int col = num % board.length;
                    manhattan+= Math.abs(row-i) + Math.abs(col-j);
                }
            }
        }
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                int pos = i * board.length + j + 1;
                if(i== board.length-1 && j== board.length-1){
                    continue;
                }
                if(!(pos == board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    // does this board equal y?
    @Override
    public boolean equals(Object y){
        if(y == null){
            return false;
        }

        if(!(y instanceof Board)){
            return false;
        }

        int[][] that = ((Board)y).board;
        if(that.length != board.length || that[0].length != board[0].length){
            return false;
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                if(board[i][j] != that[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
        int row = -1;
        int col = -1;
        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    break;
                }
            }
            if(row != -1) break;
        }

        if(row == -1 || col == -1){
            throw new IllegalArgumentException("Board is illegal!");
        }

        List<Board> neighbors = new ArrayList<>();
        // Left Neighbor
        if(col-1 >= 0){
            int[][] left = clone(board);
            int temp = left[row][col];
            left[row][col] = left[row][col-1];
            left[row][col-1] = temp;
            neighbors.add(new Board(left));
        }

        // right
        if(col+1 < board.length){
            int[][] right = clone(board);
            int temp = right[row][col];
            right[row][col] = right[row][col+1];
            right[row][col+1] = temp;
            neighbors.add(new Board(right));
        }

        // top
        if(row-1 >= 0){
            int[][] top = clone(board);
            int temp = top[row][col];
            top[row][col] = top[row-1][col];
            top[row-1][col] = temp;
            neighbors.add(new Board(top));
        }

        // Bottom
        if(row+1 < board.length){
            int[][] bottom = clone(board);
            int temp = bottom[row][col];
            bottom[row][col] = bottom[row+1][col];
            bottom[row+1][col] = temp;
            neighbors.add(new Board(bottom));
        }

        return neighbors;
    }

    private int[][] clone(int[][] board){
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin(){
        if(twin != null){
            return twin;
        }

        int[][] twinBoard = clone(board);
        boolean swapComplete = false;
        int row1=0, row2=0, col1=0, col2=0;
        while(!swapComplete){

            int pos1 = StdRandom.uniform(twinBoard.length*twinBoard.length);
            int pos2 = StdRandom.uniform(twinBoard.length*twinBoard.length);

            if(pos1 == pos2) continue;

            row1 = pos1 / twinBoard.length;
            col1 = pos1 % twinBoard.length;

            row2 = pos2 / twinBoard.length;
            col2 = pos2 % twinBoard.length;

            if(twinBoard[row1][col1] != 0 && twinBoard[row2][col2] != 0){
                swapComplete = true;
            }
        }

        int temp = twinBoard[row1][col1];
        twinBoard[row1][col1] = twinBoard[row2][col2];
        twinBoard[row2][col2] = temp;
        twin = new Board(twinBoard);
        return twin;
    }

    // unit testing (not graded)
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);

        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<n*n; i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        int[][] tiles = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                tiles[i][j] = numbers.get(i*n+j);
            }
        }

        Board b = new Board(tiles);
        System.out.println(b);
        System.out.println("Dimension of board : " + b.dimension());
        System.out.println("Hamming of board : " + b.hamming());
        System.out.println("Manhattan of board : " + b.manhattan());
        System.out.println("Twin board : " + b.twin());
        System.out.println("Is Goal Board? : " + b.isGoal());
        Iterable<Board> neighbors = b.neighbors();
        System.out.println("Printing Neighbors : ");
        for(Board neighbor : neighbors){
            System.out.println(neighbor);
        }
    }
}
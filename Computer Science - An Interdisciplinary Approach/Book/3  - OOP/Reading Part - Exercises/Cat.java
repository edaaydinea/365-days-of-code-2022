import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/******************************************************************************
 *  Compilation:  javac Cat.java
 *  Execution:    java Cat file1.txt file2.txt file3.txt output.txt
 *  Dependencies: In.java
 *  Data files:   https://introcs.cs.princeton.edu/java/31datatype/in1.jpg
 *                https://introcs.cs.princeton.edu/java/31datatype/in2.jpg
 *
 *  Reads in text files specified as the first command-line 
 *  parameters, concatenates them, and writes the result to
 *  filename specified as the last command line parameter.
 *
 *  % more in1.txt
 *  This is
 *
 *  % more in2.txt 
 *  a tiny
 *  test.
 *
 *  % java Cat in1.txt in2.txt out.txt
 *
 *  % more out.txt .
 *  This is
 *  a tiny
 *  test.
 *
 ******************************************************************************/

public class Cat {

    public static void main(String[] args) {
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }

}
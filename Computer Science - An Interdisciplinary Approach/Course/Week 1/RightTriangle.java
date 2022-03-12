/******************************************************************************
 *  Compilation:  javac RightTriangle.java
 *  Execution:    java RightTriangle 3 4 5
 *
 *  Takes three int command-line arguments and determines whether they constitute the side lengths of some right triangle
 *
 *  ~/Desktop/hello> java RightTriangle 3 4 5
 *	true
 *  ~/Desktop/hello> java RightTriangle 13 12 5
 *	true
 *  ~/Desktop/hello> java RightTriangle 1 2 3
 *	false
 *  ~/Desktop/hello> java RightTriangle -3 4 -5
 *	false
 ******************************************************************************/

public class RightTriangle {
    public static void main(String[] args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        // first calculation
        int calculation = a*a + b*b;
        int result = c*c;

        // second calculation (inversely)
        int calculation2 = b*b + c*c;
        int result2 = a*a;

        // third calculation
        int calculation3 = a*a + c*c;
        int result3 = b*b;

        boolean isHigherZero = ((a>0) && (b>0) && (c>0));

        boolean isRightTriangle = (isHigherZero && ((calculation == result) || (calculation2 == result2) || (calculation3 == result3)));

        System.out.println(isRightTriangle);
    }
}

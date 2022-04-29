public class Exercise_04 {
    public static void main(String[] args) {
        //Initialize array
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("Array in reverse order: ");
        //Loop through the array in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}

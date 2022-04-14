public class Exercise_09 {
    public static void main(String[] args) {
        System.out.println(ruler(3));
    }

    public static String ruler(int n) { // TODO: Plot
        if (n <= 0) return " ";
        return ruler(n - 1) + n + ruler(n - 1);
    }
}

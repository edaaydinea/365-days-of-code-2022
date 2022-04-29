public class Exercise_22 {
    public static void main(String[] args) {
        boolean[] b = {true, true, false, false};
        System.out.println("any() => " + any(b));
        System.out.println("all() => " + all(b));

        b = new boolean[]{false};
        System.out.println("\nany() => " + any(b));
        System.out.println("all() => " + all(b));

        b = new boolean[]{true, true};
        System.out.println("\nany() => " + any(b));
        System.out.println("all() => " + all(b));
    }

    // returns true if ANY of the elements in the array is true
    public static boolean any(boolean[] a) {
        if (a == null) return false;

        for (boolean b : a)
            if (b) return true;

        return false;
    }

    // returns true if ALL of the elements in the array are true
    public static boolean all(boolean[] a) {
        if (a == null) return false;

        for (boolean b : a)
            if (!b) return false;

        return true;
    }

}

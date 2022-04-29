import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;

public class Person {
    private final String name;
    private final long info;

    public Person(String name, long info) {
        this.name = name;
        this.info = info;
    }

    // how you're supposed to implement equals
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Person that = (Person) other;
        return (this.name.equals(that.name)) && (this.info == that.info);
    }

    public String toString() {
        return name + " " + info;
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, name);
    }

    public static void main(String[] args) {
        Person a = new Person("Alice", 1234);
        Person b = new Person("Alice", 1234);
        Person c = new Person("Bob", 1234);
        Person d = new Person("Alice", 4321);
        StdOut.println("a = " + a);
        StdOut.println("b = " + b);
        StdOut.println("c = " + c);
        StdOut.println("d = " + d);
        StdOut.println("a == a: " + a.equals(a));
        StdOut.println("a == b: " + a.equals(b));
        StdOut.println("a == c: " + a.equals(c));
        StdOut.println("a == d: " + a.equals(d));
    }

}

package supplier;

import predicate.Student;

import java.util.function.Supplier;

public class SupplierExample {

    static Supplier<Student> studentSupplier = () -> new Student(90, "Bishal",3);
    public static void main(String[] args) {
        System.out.println(studentSupplier.get().getName());
    }
}

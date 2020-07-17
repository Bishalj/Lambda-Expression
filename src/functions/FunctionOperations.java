package functions;

import java.util.Random;
import java.util.function.Function;

public class FunctionOperations {


    static Function<String, String> getUpperCase = data -> data.toUpperCase();
    static Function<String, String> addSomeString = data -> data.toUpperCase() + " Bishal";
    static Function<String, String> addSomeTitle = data -> data.toUpperCase() + " Jaiswal";
    public static void main(String[] args) {
        System.out.println("Rocks: " +
                getUpperCase
                        .apply("Java 8"));

        System.out.println("Rocks: " +
                getUpperCase
                        .andThen(addSomeString)
                        .apply("Java 8"));

        System.out.println("Rocks: " +
                getUpperCase
                        .compose(addSomeString)
                        .compose(addSomeTitle)
                        .apply("Java 8"));
    }
}

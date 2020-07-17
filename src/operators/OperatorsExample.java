package operators;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorsExample {

    static UnaryOperator<String> concat = s -> s.concat(" jaiswal");
    static BinaryOperator<String> concat2 = (a,b) -> a.concat(" " + b);

    public static void main(String[] args) {
        System.out.println(concat.apply("bishal"));
        System.out.println(concat2.apply("bishal", "jaiswal"));
    }
}

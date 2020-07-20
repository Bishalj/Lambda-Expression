package operators;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorsExample {

    static UnaryOperator<String> concat = s -> s.concat(" jaiswal");
    static BinaryOperator<String> concat2 = (a,b) -> a.concat(" " + b);

    static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

    public static void main(String[] args) {
        System.out.println(concat.apply("bishal"));
        System.out.println(concat2.apply("bishal", "jaiswal"));

        BinaryOperator<Integer> binaryOperatorMax = BinaryOperator.maxBy(comparator);
        System.out.println(binaryOperatorMax.apply(3,4));

        BinaryOperator<Integer> binaryOperatorMin = BinaryOperator.minBy(comparator);
        System.out.println(binaryOperatorMin.apply(3,4));
    }
}

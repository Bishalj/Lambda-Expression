package predicate;

import java.util.function.Predicate;

public class PredicateFI {

    static Predicate<Integer> isValueEven = i -> i%2 == 0;
    static Predicate<Integer> isDivisibleByFive = i -> i%5 == 0;
    public static void main(String[] args) {


        System.out.println(isValueEven.and(isDivisibleByFive).test(20));
        System.out.println(isValueEven.and(isDivisibleByFive).test(5));
        System.out.println(isValueEven.and(isDivisibleByFive).negate().test(5));
        System.out.println(isValueEven.negate().and(isDivisibleByFive).test(10));
        System.out.println(isValueEven.or(isDivisibleByFive).test(8));
    }
}

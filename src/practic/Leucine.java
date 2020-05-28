package practic;

import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Leucine {
    Double d = new Double("17.46d");
    Float f = new Float(23.43);
    Boolean b = new Boolean("false");
//    Character c = new Character("C");
//    Integer i = Integer.parseUnsignedInt(4);
}


class A{
    static int total = 10;
    public void call() {
        int total = 5;
        System.out.println(this.total);
    }
    public static void main (String args []) {
        A a1 = new A();
        a1.call();
        YearMonth ym1 = YearMonth.now();
        YearMonth ym2 = YearMonth.of(2016, Month.FEBRUARY);
        System.out.println(ym1.minus(Period.ofMonths(4)).getMonthValue());
        System.out.println(ym2.compareTo(ym1));
        System.out.println(ym2.until(ym1, ChronoUnit.MONTHS));
        System.out.println(ym1.until(ym2, ChronoUnit.MONTHS));

        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s1,s2) -> s1.compareTo(s2))
                .filter(s -> s.endsWith("n"))
                .orElse("yellow"));

        String first = "first";
        String second = new String("first");
        "first".concat("second");
        System.out.println(first.equals(second));
        System.out.println(first == second);
        System.out.println(first.equals("firstsecond"));
        System.out.println(second == "first");
    }


}


package method.reference;


import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceExample{

    static Function<String, String> lowerCaseFunction = String::toLowerCase;

    static Consumer<String> print = System.out::println;

    public static void main(String[] args) {
        System.out.println(lowerCaseFunction.apply("BISHal"));
        print.accept("BISHal");
        AbsClass absClass = () -> System.out.println("Display");

        absClass.display();
    }

}


@FunctionalInterface
interface AbsClass {

    void display();
}
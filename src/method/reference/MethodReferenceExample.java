package method.reference;


import java.util.function.Function;c

public class MethodReferenceExample {

    static Function<String, String> lowerCaseFunction = String::toLowerCase;

    public static void main(String[] args) {
        System.out.println(lowerCaseFunction.apply("BISHal"));
    }
}

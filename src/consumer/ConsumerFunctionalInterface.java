package consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {

    public static void main(String[] args) {
        Consumer<Integer> consumer = (s) -> System.out.println(s);
        Consumer<Integer> consumer2 = (s) -> System.out.println("Consumenr 2:" + s);
        consumer = consumer.andThen(consumer2);
        consumer.accept(25);
        consumer.accept(35);

        BiConsumer<Integer, Integer> biConsumer = (s,v) -> System.out.println(s*v);
        BiConsumer<Integer, Integer> biConsumerDivision = (s,v) -> System.out.println(1.0*s/v);

        biConsumer
                .andThen(biConsumerDivision)
                .andThen(biConsumerDivision)
                .accept(2,5)

        ;
    }
}
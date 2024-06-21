package org.xcelore;
import reactor.core.publisher.Flux;
import java.time.Duration;
public class IntervalOperator {
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .map(i -> {
                    String[] letters = {"A", "B", "C"};
                    return letters[(int) (i % 3)];
                })
                .take(5)
                .subscribe(System.out::println);

        Thread.sleep(6000); // Need to sleep to see output in console
    }
}

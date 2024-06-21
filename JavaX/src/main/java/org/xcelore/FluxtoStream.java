package org.xcelore;
import reactor.core.publisher.Flux;
import java.util.stream.Collectors;

public class FluxtoStream {
    public static void main(String[] args){

        Flux<Integer> flux = Flux.range(1,10);

        flux.toStream()
                .filter(n->n%2==0)
                .map(n->n*n)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}

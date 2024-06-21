package org.xcelore;

import reactor.core.publisher.Flux;

public class FluxExample {
    public static void main(String[] args){

        Flux.range(1, 10)
                .map(n->n*n)
                .subscribe(System.out::println);

    }
}

package org.xcelore;

import reactor.core.publisher.Flux;

public class FluxMap {
    public static void main(String[] args){
        Flux<String> flux = Flux.just("hio", "muskan", "Hijai")
                .map(String::toUpperCase);
        flux.subscribe(System.out::println);
    }
}

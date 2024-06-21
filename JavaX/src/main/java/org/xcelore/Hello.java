package org.xcelore;

import reactor.core.publisher.Mono;

public class Hello {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello, World!");

       mono.subscribe(System.out::println);

    }
}

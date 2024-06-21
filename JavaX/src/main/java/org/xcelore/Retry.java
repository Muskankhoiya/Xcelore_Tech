package org.xcelore;

import reactor.core.publisher.Flux;

public class Retry {
    public static void main(String[] args) {
        Flux.just("1", "2", "3", "invalid", "4")
                .map(Integer::parseInt)
                .retry(3)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}

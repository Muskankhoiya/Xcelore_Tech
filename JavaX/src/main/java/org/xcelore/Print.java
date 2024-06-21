package org.xcelore;

import reactor.core.publisher.Mono;

public class Print {
    public static void main(String[] args){

        Mono<Integer> mon = Mono.just(42);
        mon.subscribe(System.out::println);
    }



}

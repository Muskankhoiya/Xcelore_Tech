package org.xcelore;

import reactor.core.publisher.Flux;

public class OnError {
    public static void main(String[] args){
        Flux.just("1", "2", "3", "4", "invalie")
                .map(Integer::parseInt)
                .onErrorReturn(-1)
                .subscribe(System.out::println);
    }
}

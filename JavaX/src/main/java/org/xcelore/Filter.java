package org.xcelore;

import reactor.core.publisher.Flux;

public class Filter {
    public static void main(String[] args){
        Flux.range(1, 10)
                .filter(num -> num % 2 == 0)
                .subscribe(System.out::println);
    }
}

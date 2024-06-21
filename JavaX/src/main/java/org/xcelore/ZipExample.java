package org.xcelore;

import reactor.core.publisher.Flux;

public class ZipExample {
    public static void main(String[] args){
        Flux<Integer> f1 = Flux.just(1,2,3);
        Flux<Integer> f2 = Flux.just(4,5,6);

        Flux.zip(f1,f2)
                .map(tuple -> tuple.getT1()+ " " + tuple.getT2())
                .subscribe(System.out::println);
    }
}

package org.xcelore;

import reactor.core.publisher.Flux;

public class AdvanceOperator {
    public static void main(String[] args){
       Flux.range(1, 10)
               .reduce(0, Integer::sum)
            .subscribe(result -> System.out.println("Sum: " + result));
}
}

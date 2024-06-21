//package org.xcelore;
//
//import org.reactivestreams.Publisher;
//import reactor.core.publisher.Flux;
//
//public class PublisherExample {
//
//    public static void main(String[] args) {
//
//        Publisher<Integer> customPublisher = subscribe -> {
//            Flux<Integer> flux = Flux.create(emitter -> {
//                for (int i = 0; i <= 5; i++) {
//                    emitter.next(i);
//                }
//                emitter.complete();
//            });
//        }
//
//
//    }
//}
//

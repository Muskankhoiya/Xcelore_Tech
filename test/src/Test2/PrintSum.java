package Test2;

import java.util.function.BiConsumer;

public class PrintSum {
    public static void main(String[] args){
        BiConsumer<Integer, Integer> printsum = (a, b)-> System.out.println(a+b);
        printsum.accept(10, 20);

    }
}

package Test2;

import java.util.function.BinaryOperator;

public class Concate {
    public static void main(String[] args){

        BinaryOperator<String> concatenate = (s1, s2) -> s1 + " " + s2;

        System.out.println(concatenate.apply("Hello", "World")); // "Hello World"
    }
}

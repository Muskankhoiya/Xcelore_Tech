package Test2;

import java.util.function.BinaryOperator;

public class Maxoftwo {
    public static void main(String[] args){
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;

        // Test the BinaryOperator
        System.out.println("Maximum of 10 and 20: " + max.apply(10, 20));
    }
}

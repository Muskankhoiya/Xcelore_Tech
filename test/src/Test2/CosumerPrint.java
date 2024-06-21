package Test2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CosumerPrint {
    public static void main(String[] args){
        List<String> str = Arrays.asList("Hii", "Hellow", "muskan", "goli");
        Consumer<String> printC = System.out::println;
        str.forEach(printC);

    }
}

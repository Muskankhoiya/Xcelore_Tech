package Test2;

import java.util.function.Function;

public class ToUpperCase {
    public static void main(String[] args){
        Function<String, String> toUpper = s->s.toUpperCase();
        System.out.println(toUpper.apply("muskan"));

    }
}

package Test2;

import java.util.function.BiPredicate;

public class EqualLength {
    public static void main(String[] args){
        BiPredicate<String, String> isEqual = (str1, str2) -> str1.length()==str2.length();
        System.out.print(isEqual.test("muskan", "muskan"));

    }
}

package Test2;

import java.util.Scanner;
import java.util.function.Predicate;

public class Palindrome {
    public static void main(String[] args){


//
//        StringBuilder stringBuilder = new StringBuilder(str);
//        Predicate<String> isPalindrome = s->s.equals(stringBuilder.reverse().toString());
//        System.out.println(isPalindrome.test(str));
//    }
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        Predicate<String> isPalindrome = s -> {
            int length = s.length();
            for (int i = 0; i < length / 2; i++) {
                if (s.charAt(i) != s.charAt(length - 1 - i)) {
                    return false;
                }
            }
            return true;
        };

        System.out.println(isPalindrome.test(str)); // Output: true
    }
}

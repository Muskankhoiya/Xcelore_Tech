package Q2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OddEvenList {
    public static void main(String[] args){

        List<String> list = Arrays.asList("Hello", "iiiiii", "mskan");
        Map<Boolean, List<String>> map = list.stream()
                .collect(Collectors.partitioningBy(s->s.length()%2==0));

        System.out.println(map.get(true));
        System.out.println(map.get(false));

    }
}

package Test2;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class SquareofDouble {
    public static void main(String[] args){
        List<Double> listd = Arrays.asList(1.0, 2.3, 4.3, 3.4);

        UnaryOperator<Double> doubleList= n-> n*n;
        List<Double> result = listd.stream()
                .map(doubleList)
                .collect(Collectors.toList());

        System.out.println(result);

    }
}

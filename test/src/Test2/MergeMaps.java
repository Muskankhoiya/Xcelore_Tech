package Test2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MergeMaps {
    public static void main(String[] args) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        map1.put(1, 22);
        map1.put(2, 33);

        map2.put(3, 44);
        map2.put(4, 55);

        BiConsumer<Map<Integer, Integer>, Map<Integer, Integer>> mergemap = (m1, m2) -> {
            m2.forEach((k, v) -> m1.merge(k, v, Integer::sum));
        };

        mergemap.accept(map1,map2);

    }
}

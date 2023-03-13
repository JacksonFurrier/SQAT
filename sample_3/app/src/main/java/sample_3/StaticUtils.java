package course_3;

import java.util.*;  
import java.util.stream.*;

public class StaticUtils {

    private StaticUtils() {}

    public static List<Integer> range(int start, int end) {
        return IntStream.range(start, end)
          .boxed()
          .collect(Collectors.toList());
    }

    public static String name() {
        return "Baeldung";
    }
}
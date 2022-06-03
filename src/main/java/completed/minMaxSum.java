package completed;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class minMaxSum {

    public static void main(String[] args) {

        //miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
        miniMaxSum(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625));

    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        //Long sum = arr.stream().reduce(0, Long::sum);
        /*Long sum = 0L;
        for (Integer x : arr) {
            sum += x;
        }
        Long max = sum - Collections.max(arr);
        Long min = sum - Collections.min(arr);
        System.out.println(max +" "+ min);*/

        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
        long min = sorted.subList(0, sorted.size() - 1).stream().mapToLong(i -> (long) i).reduce(0L, Long::sum);
        long max = sorted.subList(1, sorted.size()).stream().mapToLong(i -> (long) i).reduce(0L, Long::sum);
        System.out.println(min + " " + max);

    }
}

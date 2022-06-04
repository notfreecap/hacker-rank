package completed;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class countApplesAndOranges {
    public static void main(String[] args) {

        countApplesAndOranges(7, 11, 5, 15, Arrays.asList(-2, 2, 1), Arrays.asList(5, -6));
    }

    /*
     * Complete the 'completed.countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here

        List<Integer> rangeApples = apples.stream().map(x -> x += a)
                .collect(Collectors.toList()).stream().filter(x -> (x >= s && x <= t))
                .collect(Collectors.toList());


        List<Integer> rangeOranges = oranges.stream().map(x -> x += b)
                .collect(Collectors.toList()).stream().filter(x -> (x >= s && x <= t))
                .collect(Collectors.toList());

        System.out.println(rangeApples.size());
        System.out.println(rangeOranges.size());

    }

}

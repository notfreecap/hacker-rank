package completed;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class birthdayCakeCandles {
    public static void main(String[] args) {
        birthdayCakeCandles(Arrays.asList(3, 2, 1, 3));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        return Collections.frequency(candles, Collections.max(candles));

    }
}

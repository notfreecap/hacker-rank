package completed;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class plusMinus {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(-4);
        arr.add(3);
        arr.add(-9);
        arr.add(0);
        arr.add(4);
        arr.add(1);
        plusMinus(arr);
    }

    private static final DecimalFormat df = new DecimalFormat("0.000000");

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        int a = 0;
        int b = 0;
        int c = 0;
        float sum;
        for(int val : arr){
            if (val < 0){
                a++;
            }else if (val > 0){
                b++;
            }else{
                c++;
            }
        }
        sum = a+b+c;
        System.out.println(df.format(b / sum));
        System.out.println(df.format(a / sum));
        System.out.println(df.format(c / sum));

    }
}

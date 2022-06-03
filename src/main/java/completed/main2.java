package completed;

import java.util.List;

public class main2 {
    public static void main(String[] args) {

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        /*[[11, 2, 4], [4, 5, 6], [10, 8, -12]]*/
        int positionA = 0;
        int positionB = arr.size() - 1;
        int sumA = 0;
        int sumB = 0;
        int result = 0;
        for (List<Integer> val: arr){
            result += val.get(positionA);
            positionA++;
        }
        for (List<Integer> val: arr){
            result -= val.get(positionB);
            positionB--;
        }
        System.out.println(result);
        return Math.abs(result);

        /*
        *
        6 6 7 -10 9 -3 8 9 -1
        9 7 -10 6 4 1 6 1 1
        -1 -2 4 -6 1 -4 -6 3 9
        -8 7 6 -1 -6 -6 6 -7 2
        -10 -4 9 1 -7 8 -5 3 -5
        -8 -3 -4 2 -3 7 -5 1 -5
        -2 -7 -4 8 3 -1 8 2 3
        -3 4 6 -7 -7 -8 -3 9 -6
        -2 0 5 4 4 4 -3 3 0
        *
        * */
    }

}

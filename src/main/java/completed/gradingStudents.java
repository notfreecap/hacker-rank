package completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class gradingStudents {
    public static void main(String[] args) {


        gradingStudents(Arrays.asList(73, 67, 38, 33)).stream().forEach(System.out::println);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        grades.stream().map(x ->  x = x - (x/5+1)*5 < 3 ? ((x/5+1)*5) : x);
        /*grades.stream().map(x ->

                System.out.println((x/5+1)*5)
        );*/


        return grades.stream().map(x ->  x = (x/5+1)*5 - x < 3 ? (x/5+1)*5 >= 40 ? (x/5+1)*5 : x : x)
                .collect(Collectors.toList());

    }

}

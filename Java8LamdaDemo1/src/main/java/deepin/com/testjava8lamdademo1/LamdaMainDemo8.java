package deepin.com.testjava8lamdademo1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Li on 2018/4/22.
 */

public class LamdaMainDemo8 {
    public static void main(String args[]) {
         // 用所有不同的数字创建一个正方形列表, distinct()去重复， 去掉最后的3,4
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  \nSquare Without duplicates : %s %n", numbers, distinct);

        // 求最大、最小、总和、平均值
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("\n\nHighest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

    }

}

package deepin.com.testjava8lamdademo1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Li on 2018/4/22.
 */

public class LamdaMainDemo4 {
    public static void main(String args[]){
//// 不使用lambda表达式为每个订单加上12%的税
//        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            System.out.println(price);
//        }
//
        List<Integer>  costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
    }

}

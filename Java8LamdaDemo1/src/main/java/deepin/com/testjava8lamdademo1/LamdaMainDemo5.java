package deepin.com.testjava8lamdademo1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Li on 2018/4/22.
 */

public class LamdaMainDemo5 {
    public static void main(String args[]){
//// 老方法：
//        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        double total = 0;
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            total = total + price;
//        }
//        System.out.println("Total : " + total);
//
//// 新方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }

}

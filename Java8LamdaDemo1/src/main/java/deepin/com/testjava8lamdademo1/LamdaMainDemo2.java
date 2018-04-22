package deepin.com.testjava8lamdademo1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Li on 2018/4/22.
 */

public class LamdaMainDemo2 {
    public static void main(String[] agrs){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));


        features.forEach(System.out::println);
    }
}

package deepin.com.testjava8lamdademo1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Li on 2018/4/22.
 */

public class LamdaMain {
    public static void main(String[] agrs){
        new Thread( () -> System.out.println("Java8, Lambda expression~~") ).start();

    }
}

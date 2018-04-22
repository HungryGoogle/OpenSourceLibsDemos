package deepin.com.testjava8lamdademo1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Li on 2018/4/22.
 */

public class LamdaMainDemo3 {
    public static void main(String args[]){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

//        System.out.println("Languages which starts with J :");
//        filter(languages, (str)->str.startsWith("J"));
//
//        System.out.println("Languages which ends with a ");
//        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages ------------------------- :");
        filter(languages, (str)->true);

        System.out.println("\n\nPrint no language -------------------------: ");
        filter(languages, (str)->false);

//        System.out.println("Print language whose length greater than 4:");
//        filter(languages, (str)->str.length() > 4);
    }

    public static void filter(List names, Predicate condition) {
        for(Object name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
}

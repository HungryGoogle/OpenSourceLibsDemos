package deepin.com.testjava8lamdademo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Li on 2018/4/22.
 */

public class LamdaMainDemo7 {
    public static void main(String args[]) {
        // 创建一个字符串列表，每个字符串长度大于2
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "JavaScript", "Jeep");
        List<String> filtered = languages.stream().filter(x -> x.length() > 4).collect(Collectors.toList());
        System.out.printf("Original List : %s, \nfiltered list( Length > 4 ) : %s\n\n\n", languages, filtered);

        // 将字符串换成大写并用逗号链接起来
        String stringUppers = languages.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(stringUppers);

    }

}

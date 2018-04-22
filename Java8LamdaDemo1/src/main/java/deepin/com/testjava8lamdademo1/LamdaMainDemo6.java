package deepin.com.testjava8lamdademo1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Li on 2018/4/22.
 */

public class LamdaMainDemo6 {
    public static void main(String args[]){
// 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
// 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "JavaScript", "Jeep");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println("which starts with 'J' and four letter long is : " + n));
    }

}

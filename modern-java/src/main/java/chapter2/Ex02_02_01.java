package chapter2;

import java.util.ArrayList;
import java.util.List;

public class Ex02_02_01 {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}

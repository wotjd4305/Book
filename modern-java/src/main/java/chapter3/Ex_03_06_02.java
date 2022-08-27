package chapter3;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex_03_06_02 {
    public static void main(String[] args) {
        Supplier<Apple> c1 = Apple::new;
        Apple apple1 = c1.get();

        Function<Integer, Apple> f1 = Apple::new;
        Apple apple2 = f1.apply(150);

        List<Integer> weights = Arrays.asList(1,2,3,4);
        List<Apple> apples = map(weights, f1);

    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> function){
        List<Apple> result = new ArrayList<>();
        for(Integer w : list){
            result.add(function.apply(w));
        }
        return result;
    }
}

package chapter6;

import chapter4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

public class Ex_06_02_04 {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 150, Dish.Type.MEAT),
            new Dish("beef", false, 100, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 120, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.MEAT),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args){
        //
        int totalCalories = menu.stream()
                .collect(reducing(0, Dish::getCalories, (i, j) -> i+j));
        System.out.println(totalCalories);

        //
        int totalCalories2 = menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum)
                .get();
        System.out.println(totalCalories2);


    }
}

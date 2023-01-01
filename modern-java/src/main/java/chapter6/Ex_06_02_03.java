package chapter6;

import chapter4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Ex_06_02_03 {
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
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(joining());
        System.out.println(shortMenu);

        //
        String shortMenu2 = menu.stream()
                .map(Dish::getName)
                .collect(joining(", "));
        System.out.println(shortMenu2);


    }
}

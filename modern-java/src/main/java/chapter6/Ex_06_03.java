package chapter6;

import chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Ex_06_03 {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 150, Dish.Type.MEAT),
            new Dish("beef", false, 100, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 120, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {
        //
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        //
        Map<Dish.CaloricLevel, List<Dish>> dishesByType2 = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }));
        System.out.println(dishesByType2);

        //
        Map<Dish.Type, List<Dish>> dishesByType3 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println(dishesByType3);

        //
        Map<Dish.Type, List<String>> dishesByType4 = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println(dishesByType4);
    }



}

package chapter6;

import chapter4.Dish;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Ex_06_04 {
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
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream()
                        .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu.get(true));
        System.out.println(partitionedMenu.get(false));

        //
        Map<Boolean, Map<Dish.Type, List<Dish>>> partitionedMenu2 =
                menu.stream()
                        .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(partitionedMenu2.get(true));
        System.out.println(partitionedMenu2.get(false));

    }

}

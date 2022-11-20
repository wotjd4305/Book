package chapter5;

import chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex_05 {
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
    public static void main(String[] args) {
      List<Dish> vegetarianMenu = menu.stream()
              .filter(Dish::isVegetarian)
              .collect(Collectors.toList());

        System.out.println(vegetarianMenu);

        // basic
        System.out.println();
        List<Dish> filteredMenu = menu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        System.out.println(filteredMenu);

        // takewhile
        System.out.println();
        List<Dish> filteredMenuByUsingTakeWhile = menu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        System.out.println(filteredMenuByUsingTakeWhile);

        // dropwhile
        System.out.println();
        List<Dish> filteredMenuByUsingDropwhile = menu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        System.out.println("ListDropwhile : " +filteredMenuByUsingDropwhile);


        // skip
        System.out.println();
        List<Dish> filteredMenuByUsingSkip = menu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("skip : " +filteredMenuByUsingSkip);

    }
}

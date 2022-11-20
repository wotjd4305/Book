package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex_04_03 {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.MEAT),
            new Dish("salmon", false, 450, Dish.Type.FISH)
            );

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        // 외부 반복
        for (Dish dish : menu) {
            names.add(dish.getName());
        }
        System.out.println(names);

        // 내부 반복
        List<String> names2 = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(names2);
    }
}

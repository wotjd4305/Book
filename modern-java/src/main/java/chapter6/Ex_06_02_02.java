package chapter6;

import chapter4.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

public class Ex_06_02_02 {
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
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().max(dishCaloriesComparator);
        mostCalorieDish.ifPresent(dish -> System.out.println(dish.getCalories()));

        //
        int totalCalories = menu.stream()
                .collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        //
        double avgCalories = menu.stream()
                .collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        //
        IntSummaryStatistics menuStatistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
        System.out.println(menuStatistics.getMax());

    }
}

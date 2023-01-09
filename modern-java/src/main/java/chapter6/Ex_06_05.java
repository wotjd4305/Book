package chapter6;

import chapter4.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex_06_05 {

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

    public static void main(String args[]){
        //
        List<Dish> dishes = menu.stream()
                .collect(new ToListCollector<Dish>());
        System.out.println(dishes);

        //
        List<Dish> dishes2 = menu.stream()
                .collect(ArrayList::new, List::add, List::addAll);
        System.out.println(dishes2);

        //

    }
}

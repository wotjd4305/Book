package chapter3;

import chapter2.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static chapter2.Color.GREEN;
import static chapter2.Color.RED;

public class Ex_03_07_03 {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(10,RED), new Apple(20,GREEN));
        inventory.sort(Comparator.comparing(apple -> apple.getWeight()));

        List<Apple> inventory2 = Arrays.asList(new Apple(10,RED), new Apple(20,GREEN));
        inventory2.sort(Comparator.comparing(Apple::getWeight));
    }
}

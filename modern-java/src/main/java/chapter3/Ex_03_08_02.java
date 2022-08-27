package chapter3;

import chapter2.Apple;
import chapter2.Color;

import java.util.function.Predicate;

public class Ex_03_08_02 {

    public static void main(String[] args) {
        Predicate<Apple> redApplePedicate = (Apple apple) -> apple.getColor().equals(Color.RED);

        // 빨간 사과인지 확인
        Predicate<Apple> predicate1 = redApplePedicate;

        // 빨간 사과 && 무게가 20이상
        Predicate<Apple> predicate2 = predicate1.and(apple -> apple.getWeight() > 20);

        //( 빨간 사과 && 무게가 20이상 ) || 초록사과
        Predicate<Apple> predicate3 = predicate2.or(apple -> apple.getColor().equals(Color.GREEN));

        System.out.println(predicate3.test(new Apple(30, Color.GREEN))); // true
        System.out.println(predicate3.test(new Apple(20, Color.RED))); // false
    }
}

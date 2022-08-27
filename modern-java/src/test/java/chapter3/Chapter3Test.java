package chapter3;

import chapter2.Apple;
import chapter2.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Chapter3Test {

    @Test
    public void test() throws IOException {
        //given
        var bufferProcessor = new Ex_03_03_04();
        var oneLine = bufferProcessor.processFile((BufferedReader br) -> br.readLine());
        var twoLine = bufferProcessor.processFile((BufferedReader br) -> br.readLine() + System.lineSeparator() + br.readLine());

        //when
        var actual1 = "first line";
        var actual2 = "first line" + System.lineSeparator() +"second line";

        //then
        Assertions.assertEquals(actual1, oneLine);
        Assertions.assertEquals(actual2, twoLine);
    }


    @Test
    public void 특별한_void_호환_규칙(){
        var list = new ArrayList<String>();

        Predicate<String> predicate = (String str) -> list.add(str);
        Consumer<String> consumer = (String str) -> list.add(str);
    }

    @Test
    public void Predicate_조합(){
        //given
        Predicate<Apple> predicate1 = (Apple apple) -> apple.getColor().equals(Color.RED);;
        Predicate<Apple> predicate2 = predicate1.and(apple -> apple.getWeight() > 20);
        Predicate<Apple> predicate3 = predicate2.or(apple -> apple.getColor().equals(Color.GREEN));

        var redApple = new Apple(30, Color.RED);
        var greenApple = new Apple(5, Color.GREEN);

        //when
        var actual1 = predicate3.test(redApple);
        var actual2 = predicate3.test(greenApple);

        //then
        Assertions.assertTrue(actual1);
        Assertions.assertTrue(actual2);
    }


}
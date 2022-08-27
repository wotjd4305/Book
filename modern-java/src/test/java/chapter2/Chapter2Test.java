package chapter2;

import chapter2.stategy.AppleHeavyWeightPredicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Chapter2Test {

    @Test
    public void 동작_파라미터_1(){
        //given
        var predicate = new AppleHeavyWeightPredicate();
        var apple1 = new Apple(200, Color.RED);
        var list = List.of(apple1);

        //when
        var actual = Ex02_02_01.filterApples(list, predicate);

        //then
        Assertions.assertEquals(1, actual.size());

    }

    @Test
    public void 여섯번째_람다() {
        //given
        var predicate = new AppleHeavyWeightPredicate();
        var apple1 = new Apple(200, Color.RED);
        var list = List.of(apple1);

        //when
        var actual = Ex02_02_01.filterApples(list, (Apple apple) -> Color.RED.equals(apple.getColor()));

        //then
        Assertions.assertEquals(1, actual.size());
    }


    }
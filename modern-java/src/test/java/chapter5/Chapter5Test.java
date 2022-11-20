package chapter5;

import chapter2.Apple;
import chapter2.Color;
import chapter2.Ex02_02_01;
import chapter2.stategy.AppleHeavyWeightPredicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter5Test {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Test
    public void practice_5_6_1() {
        //when
        List<Transaction> actual = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        List<Transaction> expect = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2011, 400)
        );


        //then
        System.out.println(actual.toString());
        Assertions.assertEquals(actual, expect);
    }

    @Test
    public void practice_5_6_2() {
        //when
        List<String> actual = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        //then
        List<String> expect = Arrays.asList(
                "Cambridge", "Milan"
        );

        System.out.println(actual.toString());
        Assertions.assertEquals(actual, expect);
    }

    @Test
    public void practice_5_6_3() {
        //when
        List<Trader> actual = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        //then
        List<Trader> expect = Arrays.asList(
                new Trader("Alan", "Cambridge"),
                new Trader("Brian", "Cambridge"),
                new Trader("Raoul", "Cambridge")
        );

        System.out.println(actual.toString());
        Assertions.assertEquals(expect, actual);

    }



    @Test
    public void practice_5_6_4() {
        //when
        String actual = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .reduce("", (n1,n2) -> n1 + n2);
        //then
        String expect = "AlanBrianMarioMarioRaoulRaoul";

        System.out.println(actual.toString());
        Assertions.assertEquals(expect, actual);

    }



    @Test
    public void practice_5_6_5() {
        //when
        boolean actual = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .anyMatch(t -> t.equals("Milan"));

        //then
        boolean expect = true;

        System.out.println(actual);
        Assertions.assertEquals(expect, actual);

    }
}
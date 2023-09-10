package chapter8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Chapte8Test {

    @Test
    public void quiz_8_2_Before() {
        //given
        Map<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);

        Iterator<Map.Entry<String, Integer>> iterator = movies.entrySet().iterator();

        // when
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 10) {
                iterator.remove();
            }
        }

        // then
        Assertions.assertEquals(Map.ofEntries(
                Map.entry("Matrix", 15),
                Map.entry("JamesBond", 20)), movies);
    }

    @Test
    public void quiz_8_2_After() {
        //given
        Map<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);

        // when
       movies.entrySet()
               .removeIf(key -> key.getValue() < 10);

        // then
        Assertions.assertEquals(Map.ofEntries(
                Map.entry("Matrix", 15),
                Map.entry("JamesBond", 20)), movies);
    }
}
package chapter5;

import chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex_05_03 {
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
        //
        String[] arrayOfWords = {"GoodBye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        // 잘못된 방법
        List<Stream<String>> basicList = Arrays.stream(arrayOfWords)
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        // FlatMap 사용
        System.out.println();
        List<String> flatMapList = Arrays.stream(arrayOfWords)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(flatMapList);

        // ex2
        System.out.println();
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(4,5);

        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i,j}))
                .collect(Collectors.toList());

        for(int[] list : pairs){
            System.out.println(Arrays.toString(list));
        }

        // ex3
        System.out.println();
        List<Integer> numbers3 = Arrays.asList(1,2,3);
        List<Integer> numbers4 = Arrays.asList(4,5);

        List<int[]> pairs2 = numbers3.stream()
                .flatMap(i -> numbers4.stream()
                        .filter(j -> (i+j) % 3 == 0)
                        .map(j -> new int[]{i,j})
                )
                .collect(Collectors.toList());

        for(int[] list : pairs2){
            System.out.println(Arrays.toString(list));
        }

    }
}

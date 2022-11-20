package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Ex_05_05 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        //
        Integer sum1 =  numbers.stream()
                .reduce(0,(a,b) -> a+b);
        System.out.println(sum1);

        // 초기값 없음
        System.out.println();
        Optional<Integer> sum2Optional = numbers.stream()
                .reduce(Integer::sum);
        int sum2 = sum2Optional.orElseGet(() -> 0);
        System.out.println(sum2);

        // 퀴즈 1
        System.out.println();
        List<Integer> menu = Arrays.asList(1,2,3,4,5);

        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a,b) -> a+b);

        System.out.println(count);

    }
}

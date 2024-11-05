package chapter7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ex_07_01 {

    public static void main(String args[]){

        // 직렬 처리 - 정상
        System.out.println();
        System.out.println(sideEffectSum(1000));

        // 병렬 처리 - 비정상
        System.out.println();
        System.out.println(sideEffectParallelSum(1000));

        // 병렬 스트림 - 정상
        System.out.println();
        System.out.println(parallelSum(1000));
    }


    public static long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static class Accumulator{
        public long total = 0;
        public void add(long value){ total += value;}
    }
}

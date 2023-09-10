package chapter7;

import java.util.stream.LongStream;

public class Ex_07_01 {

    public static void main(String args[]){



    }

    public long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public long sideEffectParallelSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public class Accumulator{
        public long total = 0;
        public void add(long value){ total += value;}
    }
}

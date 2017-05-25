package chap6;

import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by josgar on 25/05/2017.
 */

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class Chap6Test {

    @Test
    public void sumSquareParallel() throws Exception {
        assertEquals(328350, sequentialSumOfSquares(IntStream.range(0, 100)));
    }

    @Test
    public void multiplyThroughParallel() throws Exception {
        List<Integer> listOfNumbers = IntStream
                .range(1, 4)
                .boxed()
                .collect(Collectors.toList());

        assertEquals(multiplyThrough(listOfNumbers), 30);
    }


    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                .sum();
    }

    public static int multiplyThrough(List<Integer> listOfNumbers) {
        return 5 * listOfNumbers.stream().parallel()
                .reduce(1, (acc, x) -> x * acc);
    }

    @GenerateMicroBenchmark
    public int fastSumOfSquares(ArrayList<Integer> listOfNumbers) {
        return listOfNumbers
                .stream()
                .parallel()
                .mapToInt(x -> x * x)
                .sum();
    }
}

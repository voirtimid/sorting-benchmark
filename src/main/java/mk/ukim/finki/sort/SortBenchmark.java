package mk.ukim.finki.sort;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SortBenchmark {

    @State(Scope.Thread)
    public static class ArrayState {
        @Param({ "10", "20", "40", "60", "80", "100", "200", "400", "600", "800", "1000", "2000", "4000", "6000", "8000", "10000", "20000", "40000", "60000", "80000", "100000", "200000", "400000", "600000", "800000", "1000000", "2000000", "4000000", "6000000", "8000000", "10000000" })
        private int size;

        private int[] array;

        @Setup(Level.Trial)
        public void setup() {
            array = new int[size];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt();
            }
        }

        public int[] getArray() {
            return array;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sort(ArrayState state) {
        Sort.sort(state.getArray());
    }
}

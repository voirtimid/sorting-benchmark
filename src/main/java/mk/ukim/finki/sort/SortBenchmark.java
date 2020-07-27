package mk.ukim.finki.sort;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SortBenchmark {

    @State(Scope.Thread)
    public static class ArrayState {
        @Param({ "10", "20", "50", "80", "90", "100", "200", "500", "800", "900", "1000", "2000", "5000", "8000", "9000", "10000", "20000", "50000", "80000", "90000", "100000", "500000", "1000000", "5000000", "10000000" })
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

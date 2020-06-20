package mk.ukim.finki.sort;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QuickSortBenchmark {

    @State(Scope.Thread)
    public static class ArrayState {
//        @Param({ "10", "100", "1000", "10000", "100000", "1000000", "10000000" })
        @Param({ "10" })
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

        public int getSize() {
            return size;
        }

        public int[] getArray() {
            return array;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sort(ArrayState state) {
        QuickSort.quickSort(state.getArray(), 0, state.getSize() - 1);
    }
}

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1, time = 40, timeUnit = TimeUnit.SECONDS) // число итераций для прогрева нашей функции
@State(Scope.Benchmark)
@Fork(3)
@Measurement(iterations = 1, time = 40, timeUnit = TimeUnit.SECONDS, batchSize = 1) //количество итераций функции
public class ArrayListBenchmark {
    List<Integer> list;
    Set<Integer> hashset;
    Set<Integer> treeSet;
    Set<Integer> linkedHashSet;
    Map<Integer, String> treemap;
    Map<Integer, String> hashmap;
    Map<Integer, String> linkedHashMap;


    @Param({"1", "10", "100", "1000", "10000", "1000000"})
    public int value;

    @Setup(Level.Iteration)
    public void setup() {
        list = new ArrayList<>();
        hashset = new HashSet<>();
        treeSet = new TreeSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treemap = new TreeMap<>();
        hashmap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();

        for (int i = 0; i < value; i++) {
            list.add(i);
            hashset.add(i);
            treeSet.add(i);
            linkedHashSet.add(i);
            treemap.put(i, "value " + i);
            hashmap.put(i, "value " + i);
            linkedHashMap.put(i, "value " + i);
        }
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ArrayListBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testArrayListAddLast() {
        list.add(value + 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testArrayListAddFirst() {
        list.add(0, value + 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testArrayListAddMiddle() {
        list.add(list.size() / 2, value + 3);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public Integer testArrayListGetFirst() {
        return list.get(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public Integer testArrayListGetEnd() {
        return list.get(list.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public Integer testArrayListGetMiddle() {
        return list.get(list.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testArrayListDeleteLast() {
        list.remove(list.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testArrayListDeleteFirst() {
        list.remove(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testArrayListDeleteMiddle() {
        list.remove(list.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHashSetAddLast() {
        hashset.add(value + 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testHashSetContainsFirst() {
        return hashset.contains(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testHashSetContainsEnd() {
        return hashset.contains(hashset.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testHashSetContainsMiddle() {
        return hashset.contains(hashset.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHashSetDeleteFirst() {
        hashset.remove(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHashSetDeleteLast() {
        hashset.remove(hashset.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHashSetDeleteMiddle() {
        hashset.remove(hashset.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testTreeSetAdd() {
        treeSet.add(value + 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testTreeSetContainsFirst() {
        return treeSet.contains(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testTreeSetContainsEnd() {
        return treeSet.contains(treeSet.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testTreeSetContainsMiddle() {
        return treeSet.contains(treeSet.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testTreeSetDeleteFirst() {
        treeSet.remove(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testTreeSetDeleteLast() {
        treeSet.remove(treeSet.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testTreeSetDeleteMiddle() {
        treeSet.remove(treeSet.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testLinkedHashSetAdd() {
        linkedHashSet.add(value + 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testLinkedHashSetContainsFirst() {
        return linkedHashSet.contains(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testLinkedHashSetContainsEnd() {
        return linkedHashSet.contains(linkedHashSet.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean testLinkedHashSetContainsMiddle() {
        return linkedHashSet.contains(linkedHashSet.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testLinkedHashSetDeleteFirst() {
        linkedHashSet.remove(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testLinkedHashSetDeleteLast() {
        linkedHashSet.remove(linkedHashSet.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testLinkedHashSetDeleteMiddle() {
        linkedHashSet.remove(linkedHashSet.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testTreeMapAdd() {
        treemap.put(value + 1, "value " + (value + 1));
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testTreeMapGetFirst() {
        return treemap.get(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testTreeMapGetEnd() {
        return treemap.get(treemap.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testTreeMapGetMiddle() {
        return treemap.get(treemap.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testTreeMapDeleteFirst() {
        treemap.remove(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testTreeMapDeleteLast() {
        treemap.remove(treemap.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testTreeMapDeleteMiddle() {
        treemap.remove(treemap.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void hashMapAdd() {
        hashmap.put(value + 1, "value " + (value + 1));
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testHashMapGetFirst() {
        return hashmap.get(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testHashMapGetEnd() {
        return hashmap.get(hashmap.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testHashMapGetMiddle() {
        return hashmap.get(hashmap.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHashMapDeleteFirst() {
        hashmap.remove(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHashMapDeleteLast() {
        hashmap.remove(treemap.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHashMapDeleteMiddle() {
        hashmap.remove(treemap.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedHashMapAdd() {
        linkedHashMap.put(value + 1, "value " + (value + 1));
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testLinkedHashMapGetFirst() {
        return linkedHashMap.get(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testLinkedHashMapGetEnd() {
        return linkedHashMap.get(linkedHashMap.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String testLinkedHashMapGetMiddle() {
        return linkedHashMap.get(linkedHashMap.size() / 2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testLinkedHashMapDeleteFirst() {
        linkedHashMap.remove(0);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testLinkedHashMapDeleteLast() {
        linkedHashMap.remove(linkedHashMap.size() - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testLinkedHashMapDeleteMiddle() {
        linkedHashMap.remove(linkedHashMap.size() / 2);
    }

}

package test

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder

import java.util.concurrent.TimeUnit
import scala.collection.mutable
import scala.collection.mutable.*


@BenchmarkMode(Array(Mode.AverageTime, Mode.Throughput))
@Warmup(iterations = 1, time = 45, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Timeout(time = 60, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
@Measurement(iterations = 1, batchSize = 1, time = 45, timeUnit = TimeUnit.SECONDS)
class CollectionTest {
  var list: mutable.Buffer[Integer] = null
  var hashset: mutable.Set[Integer] = null
  var treeSet: mutable.Set[Integer] = null
  var linkedHashSet: mutable.Set[Integer] = null
  var treemap: mutable.Map[Integer, String] = null
  var hashmap: mutable.Map[Integer, String] = null
  var linkedHashMap: mutable.Map[Integer, String] = null

  @Param(Array("1", "10", "100", "1000", "10000", "100000")) var value = 0

  @Setup(Level.Iteration) def setup(): Unit = {
    list = new ArrayBuffer[Integer]
    hashset = new HashSet[Integer]
    treeSet = new TreeSet[Integer]
    linkedHashSet = new LinkedHashSet[Integer]
    treemap = new TreeMap[Integer, String]
    hashmap = new HashMap[Integer, String]
    linkedHashMap = new LinkedHashMap[Integer, String]
    for (i <- 0 until value) {
      list.append(i)
      hashset.add(i)
      treeSet.add(i)
      linkedHashSet.add(i)
      treemap.put(i, "value " + i)
      hashmap.put(i, "value " + i)
      linkedHashMap.put(i, "value " + i)
    }
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListAddLast(): Unit = {
    list.append(value + 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListAddFirst(): Unit = {
    list.insert(0, value + 2)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListAddMiddle(): Unit = {
    list.insert(list.size / 2, value + 3)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListGetFirst: Integer = list.head

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListGetEnd: Integer = list.last

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListGetMiddle: Integer = list.apply(list.size / 2)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListDeleteLast(): Unit = {
    list.remove(list.size - 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListDeleteFirst(): Unit = {
    list.remove(0)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testArrayListDeleteMiddle(): Unit = {
    list.remove(list.size / 2)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashSetAddLast(): Unit = {
    hashset.add(value + 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashSetContainsFirst: Boolean = hashset.contains(0)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashSetContainsEnd: Boolean = hashset.contains(hashset.size - 1)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashSetContainsMiddle: Boolean = hashset.contains(hashset.size / 2)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashSetDeleteFirst(): Unit = {
    hashset.remove(0)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashSetDeleteLast(): Unit = {
    hashset.remove(hashset.size - 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashSetDeleteMiddle(): Unit = {
    hashset.remove(hashset.size / 2)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeSetAdd(): Unit = {
    treeSet.add(value + 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeSetContainsFirst: Boolean = treeSet.contains(0)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeSetContainsEnd: Boolean = treeSet.contains(treeSet.size - 1)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeSetContainsMiddle: Boolean = treeSet.contains(treeSet.size / 2)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeSetDeleteFirst(): Unit = {
    treeSet.remove(0)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeSetDeleteLast(): Unit = {
    treeSet.remove(treeSet.size - 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeSetDeleteMiddle(): Unit = {
    treeSet.remove(treeSet.size / 2)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashSetAdd(): Unit = {
    linkedHashSet.add(value + 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashSetContainsFirst: Boolean = linkedHashSet.contains(0)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashSetContainsEnd: Boolean = linkedHashSet.contains(linkedHashSet.size - 1)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashSetContainsMiddle: Boolean = linkedHashSet.contains(linkedHashSet.size / 2)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashSetDeleteFirst(): Unit = {
    linkedHashSet.remove(0)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashSetDeleteLast(): Unit = {
    linkedHashSet.remove(linkedHashSet.size - 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashSetDeleteMiddle(): Unit = {
    linkedHashSet.remove(linkedHashSet.size / 2)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeMapAdd(): Unit = {
    treemap.put(value + 1, "value " + (value + 1))
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeMapGetFirst: String = treemap.apply(0)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeMapGetEnd: String = treemap.apply(treemap.size - 1)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeMapGetMiddle: String = treemap.apply(treemap.size / 2)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeMapDeleteFirst(): Unit = {
    treemap.remove(0)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeMapDeleteLast(): Unit = {
    treemap.remove(treemap.size - 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testTreeMapDeleteMiddle(): Unit = {
    treemap.remove(treemap.size / 2)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def hashMapAdd(): Unit = {
    hashmap.put(value + 1, "value " + (value + 1))
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashMapGetFirst: String = hashmap.apply(0)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashMapGetEnd: String = hashmap.apply(hashmap.size - 1)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashMapGetMiddle: String = hashmap.apply(hashmap.size / 2)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashMapDeleteFirst(): Unit = {
    hashmap.remove(0)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashMapDeleteLast(): Unit = {
    hashmap.remove(treemap.size - 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testHashMapDeleteMiddle(): Unit = {
    hashmap.remove(treemap.size / 2)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def linkedHashMapAdd(): Unit = {
    linkedHashMap.put(value + 1, "value " + (value + 1))
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashMapGetFirst: String = linkedHashMap.apply(0)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashMapGetEnd: String = linkedHashMap.apply(linkedHashMap.size - 1)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashMapGetMiddle: String = linkedHashMap.apply(linkedHashMap.size / 2)

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashMapDeleteFirst(): Unit = {
    linkedHashMap.remove(0)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashMapDeleteLast(): Unit = {
    linkedHashMap.remove(linkedHashMap.size - 1)
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS) def testLinkedHashMapDeleteMiddle(): Unit = {
    linkedHashMap.remove(linkedHashMap.size / 2)
  }
}
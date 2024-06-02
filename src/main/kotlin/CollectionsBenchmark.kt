package org.example

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1, time = 45, timeUnit = TimeUnit.SECONDS) // число итераций для прогрева нашей функции
@State(Scope.Benchmark)
@Fork(1)
@Timeout(time = 60, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, batchSize = 1, time = 60, timeUnit = TimeUnit.SECONDS) //количество итераций функции
open class CollectionsBenchmark {
    var list: MutableList<Int>? = null
    var hashset: MutableSet<Int>? = null
    var treeSet: MutableSet<Int>? = null
    var linkedHashSet: MutableSet<Int>? = null
    var treemap: MutableMap<Int, String>? = null
    var hashmap: MutableMap<Int, String>? = null
    var linkedHashMap: MutableMap<Int, String>? = null

//    7 * 9 = 63

    @Param("1", "10", "100", "1000", "10000", "1000000")
    var value: Int = 0

    @Setup(Level.Iteration)
    fun setup() {
        list = ArrayList()
        hashset = HashSet()
        treeSet = sortedSetOf()
        linkedHashSet = LinkedHashSet()
        treemap = sortedMapOf()
        hashmap = HashMap()
        linkedHashMap = LinkedHashMap()

        for (i in 0 until value) {
            list?.add(i)
            hashset?.add(i)
            treeSet?.add(i)
            linkedHashSet?.add(i)
            treemap?.set(i, "value $i")
            hashmap?.set(i, "value $i")
            linkedHashMap?.set(i, "value $i")
        }
    }


    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListAddLast() {
        list!!.add(value + 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListAddFirst() {
        list!!.add(0, value + 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListAddMiddle() {
        list!!.add(list!!.size / 2, value + 3)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListGetFirst(): Int {
        return list!![0]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListGetEnd(): Int {
        return list!![list!!.size - 1]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListGetMiddle(): Int {
        return list!![list!!.size / 2]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListDeleteLast() {
        list!!.removeAt(list!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListDeleteFirst() {
        list!!.removeAt(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testArrayListDeleteMiddle() {
        list!!.removeAt(list!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashSetAddLast() {
        hashset!!.add(value + 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashSetContainsFirst(): Boolean {
        return hashset!!.contains(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashSetContainsEnd(): Boolean {
        return hashset!!.contains(hashset!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashSetContainsMiddle(): Boolean {
        return hashset!!.contains(hashset!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashSetDeleteFirst() {
        hashset!!.remove(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashSetDeleteLast() {
        hashset!!.remove(hashset!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashSetDeleteMiddle() {
        hashset!!.remove(hashset!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeSetAdd() {
        treeSet!!.add(value + 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeSetContainsFirst(): Boolean {
        return treeSet!!.contains(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeSetContainsEnd(): Boolean {
        return treeSet!!.contains(treeSet!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeSetContainsMiddle(): Boolean {
        return treeSet!!.contains(treeSet!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeSetDeleteFirst() {
        treeSet!!.remove(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeSetDeleteLast() {
        treeSet!!.remove(treeSet!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeSetDeleteMiddle() {
        treeSet!!.remove(treeSet!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashSetAdd() {
        linkedHashSet!!.add(value + 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashSetContainsFirst(): Boolean {
        return linkedHashSet!!.contains(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashSetContainsEnd(): Boolean {
        return linkedHashSet!!.contains(linkedHashSet!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashSetContainsMiddle(): Boolean {
        return linkedHashSet!!.contains(linkedHashSet!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashSetDeleteFirst() {
        linkedHashSet!!.remove(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashSetDeleteLast() {
        linkedHashSet!!.remove(linkedHashSet!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashSetDeleteMiddle() {
        linkedHashSet!!.remove(linkedHashSet!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeMapAdd() {
        treemap!![value + 1] = "value " + (value + 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeMapGetFirst(): String? {
        return treemap!![0]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeMapGetEnd(): String? {
        return treemap!![treemap!!.size - 1]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeMapGetMiddle(): String? {
        return treemap!![treemap!!.size / 2]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeMapDeleteFirst() {
        treemap!!.remove(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeMapDeleteLast() {
        treemap!!.remove(treemap!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testTreeMapDeleteMiddle() {
        treemap!!.remove(treemap!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun hashMapAdd() {
        hashmap!![value + 1] = "value " + (value + 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashMapGetFirst(): String? {
        return hashmap!![0]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashMapGetEnd(): String? {
        return hashmap!![hashmap!!.size - 1]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashMapGetMiddle(): String? {
        return hashmap!![hashmap!!.size / 2]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashMapDeleteFirst() {
        hashmap!!.remove(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashMapDeleteLast() {
        hashmap!!.remove(treemap!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testHashMapDeleteMiddle() {
        hashmap!!.remove(treemap!!.size / 2)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun linkedHashMapAdd() {
        linkedHashMap!![value + 1] = "value " + (value + 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashMapGetFirst(): String? {
        return linkedHashMap!![0]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashMapGetEnd(): String? {
        return linkedHashMap!![linkedHashMap!!.size - 1]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashMapGetMiddle(): String? {
        return linkedHashMap!![linkedHashMap!!.size / 2]
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashMapDeleteFirst() {
        linkedHashMap!!.remove(0)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashMapDeleteLast() {
        linkedHashMap!!.remove(linkedHashMap!!.size - 1)
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testLinkedHashMapDeleteMiddle() {
        linkedHashMap!!.remove(linkedHashMap!!.size / 2)
    }
}

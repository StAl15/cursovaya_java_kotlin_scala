package org.example

import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import kotlin.random.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val options = OptionsBuilder()
        .include(CollectionsBenchmark::class.java.simpleName)
        .forks(1)
        .warmupIterations(1)
        .measurementIterations(1)
        .resultFormat(ResultFormatType.CSV)
        .output("build/benchmark_output.log")
        .result("build/benchmark_result.csv")
        .build()
    Runner(options).run()
}
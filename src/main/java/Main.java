import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ArrayListBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(1)
                .resultFormat(ResultFormatType.CSV)
                .output("/Users/rgthardkor/Documents/benchmark_results/Scala/benchmark_output.log")
                .result("/Users/rgthardkor/Documents/benchmark_results/Scala/benchmark_result.csv")
                .build();

        new Runner(opt).run();
    }
}
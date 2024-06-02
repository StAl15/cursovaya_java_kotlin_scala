plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("kapt") version "1.9.23"
    id("me.champeau.gradle.jmh") version "0.5.2"
    id("io.morethan.jmhreport") version "0.9.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}
sourceSets.test {
    java.srcDirs("src/test")
}

dependencies {
    kapt("org.openjdk.jmh:jmh-generator-annprocess:1.25")

    implementation("org.openjdk.jmh:jmh-core:1.25")
    implementation("org.openjdk.jmh:jmh-generator-annprocess:1.25")

    api("ch.qos.logback:logback-classic:1.2.3")
    implementation("net.logstash.logback:logstash-logback-encoder:6.4")

    annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.25")

    testImplementation(kotlin("test-junit"))
    testImplementation(kotlin("test"))
}
jmhReport {
    jmhResultPath = project.file("build/result.json").absolutePath
    jmhReportOutput = project.file("build/reports/jmh").absolutePath
}

task("benchmarks", type = JavaExec::class) {
    classpath = sourceSets.getByName("test").runtimeClasspath
    mainClass = "src.main.kotlin.Main"
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
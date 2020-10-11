import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

defaultTasks("clean","build")

repositories {
    mavenCentral()
}

plugins {
    java
    application
    kotlin("jvm") version "1.4.10"
}

val cdkVersion = "1.64.0"
dependencies {
    implementation("software.amazon.awscdk:core:$cdkVersion")
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

group = "com.example"
version = "0.1"

application {
    mainClass.set("com.example.BaseCdkApp")
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("junit-jupiter")
    }
    outputs.upToDateWhen { false }
    testLogging {
        events("passed", "skipped", "failed")
    }
}

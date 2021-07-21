plugins {
    kotlin("multiplatform") version "1.5.21"
    kotlin("plugin.serialization") version "1.5.21"
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
}

group = "ktlogging"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotlinCoroutinesVersion: String by project
val kotlinSerialisationJsonVersion: String by project
val kotestVersion: String by project

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(LEGACY) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerialisationJsonVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation("io.kotest:kotest-runner-junit5:$kotestVersion")
            }
        }
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}

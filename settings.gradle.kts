import org.gradle.kotlin.dsl.maven

rootProject.name = "ksp"

pluginManagement {
//    val buildKotlinVersion: String by settings
//    val buildKspVersion: String by settings
    val build_ksp_version: String by settings
    val kotlin_version: String by settings
    val kotlin_repo_url: String? by settings

    plugins {
        kotlin("jvm") version kotlin_version apply false
        id("com.google.devtools.ksp") version build_ksp_version apply false
    }

    repositories {
        gradlePluginPortal()
        maven("https://redirector.kotlinlang.org/maven/bootstrap/")
        maven("https://www.jetbrains.com/intellij-repository/snapshots")
        google()
    }
}

include("api")
include("gradle-plugin")
include("common-deps")
include("common-util")
include("test-utils")
include("symbol-processing")
include("integration-tests")
include("kotlin-analysis-api")
include("symbol-processing-aa-embeddable")
include("cmdline-parser-gen")

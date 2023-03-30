rootProject.name = "ksp"

pluginManagement {
    val kotlin_version: String? by settings
    val kotlin_repo_url: String? by settings
    plugins {
        kotlin("jvm") version (kotlin_version ?: "1.8.0")
    }
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap/")
        maven("https://www.jetbrains.com/intellij-repository/snapshots")
        kotlin_repo_url?.also { maven(it) }
    }
}

include("api")
include("gradle-plugin")
include("common-util")
include("test-utils")
include("compiler-plugin")
include("symbol-processing")
include("symbol-processing-cmdline")
include("integration-tests")
include("kotlin-analysis-api")

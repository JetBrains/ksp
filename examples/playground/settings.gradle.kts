pluginManagement {
    val kotlinVersion: String? by settings
    val kspVersion: String? by settings
    val kotlin_repo_url: String? by settings
    plugins {
        id("com.google.devtools.ksp") version (kspVersion ?: "1.8.0-1.0.9")
        kotlin("jvm") version (kotlinVersion ?: "1.8.0")
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
        kotlin_repo_url?.also { maven(it) }
    }
}

dependencyResolutionManagement {
    @Suppress("LocalVariableName") val kotlin_repo_url: String? by settings

    repositories {
        google()
        mavenCentral()
        kotlin_repo_url?.also { maven(it) }
    }
}
rootProject.name = "playground"

include(":workload")
include(":test-processor")

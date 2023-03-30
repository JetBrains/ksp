@Suppress("LocalVariableName")
pluginManagement {
    val kotlin_version: String? by settings
    val kspVersion: String? by settings
    val kotlin_repo_url: String? by settings
    plugins {
        id("com.google.devtools.ksp") version (kspVersion ?: "1.8.0-1.0.9")
        kotlin("jvm") version (kotlin_version ?: "1.8.0")
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        kotlin_repo_url?.also { maven(it) }
    }
}

dependencyResolutionManagement {
    @Suppress("LocalVariableName") val kotlin_repo_url: String? by settings

    repositories {
        google()
        mavenCentral()
        mavenLocal()
        kotlin_repo_url?.also { maven(it) }
    }
}
rootProject.name = "playground"

include(":workload")
include(":test-processor")

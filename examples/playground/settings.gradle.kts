@Suppress("LocalVariableName")
pluginManagement {
    val kotlin_version: String? by settings
    val kspVersion: String? by settings
    val kotlin_repo_url: String? by settings
    plugins {
        id("com.google.devtools.ksp") version (kspVersion ?: "2.1.20-Beta1-1.0.29")
        kotlin("jvm") version (kotlin_version ?: "2.1.0-Beta1")
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

pluginManagement {
    val kotlin_version: String by settings
    val kspVersion: String by settings
    val kotlin_repo_url: String by settings
    plugins {
        id("com.google.devtools.ksp") version kspVersion
        kotlin("jvm") version kotlin_version
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        kotlin_repo_url.also { maven(it) }
    }
}

rootProject.name = "playground"

include(":annotations")
include(":processors")
include(":workload")

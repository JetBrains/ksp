import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm")
}

allprojects {
    val kotlin_language_version: String by project
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
        compilerOptions {
            languageVersion.set(KotlinVersion.fromVersion(kotlin_language_version))
            logger.warn("Configured kotlin Language Version for the project ${project.name} is : ${languageVersion.get()}")
            apiVersion.set(languageVersion)
            logger.warn("Configured kotlin Api Version for the project ${project.name} is : ${apiVersion.get()}")
        }
    }
}

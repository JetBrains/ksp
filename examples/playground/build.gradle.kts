import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm")
}

allprojects {
    val kotlin_repo_url: String by project

    repositories {
        mavenCentral()
        kotlin_repo_url.also { maven(it) }
        mavenLocal()
    }

    val kotlin_language_version: String by project
    val kotlin_api_version: String by project
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
        compilerOptions {
            languageVersion.set(KotlinVersion.fromVersion(kotlin_language_version))
            logger.warn("Configured kotlin Language Version for the project ${project.name} is : ${languageVersion.get()}")
            apiVersion.set(KotlinVersion.fromVersion(kotlin_api_version))
            logger.warn("Configured kotlin Api Version for the project ${project.name} is : ${apiVersion.get()}")
            allWarningsAsErrors.set(false)
            freeCompilerArgs.addAll(
                "-Xreport-all-warnings",
                "-Xrender-internal-diagnostic-names",
            )
            project.findProperty("kotlin_additional_cli_options")?.let {
                freeCompilerArgs.addAll((it as String).trim().split(" ").toList())
            }
        }
    }
}

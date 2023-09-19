import com.google.devtools.ksp.gradle.KspTaskJvm
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") apply false

}

allprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompilationTask<*>>().configureEach {
        if (this is KspTaskJvm) {
            compilerOptions {
                getOverriddenKspLanguageVersion(project)?.also { languageVersion.set(KotlinVersion.fromVersion(it)) }
                getOverriddenKspApiVersion(project)?.also { apiVersion.set(KotlinVersion.fromVersion(it)) }
            }
        } else
            compilerOptions {
                getOverriddenKotlinLanguageVersion(project)?.also { languageVersion.set(KotlinVersion.fromVersion(it)) }
                getOverriddenKotlinApiVersion(project)?.also { apiVersion.set(KotlinVersion.fromVersion(it)) }
            }
    }
}

import com.google.devtools.ksp.gradle.KspTaskJvm
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") apply false

}

subprojects {

    tasks.withType<KotlinCompilationTask<*>>().configureEach {
        if (this is KspTaskJvm) return@configureEach
        compilerOptions {
            getOverriddenKotlinLanguageVersion(project)?.also { languageVersion.set(KotlinVersion.fromVersion(it)) }
            getOverriddenKotlinApiVersion(project)?.also { apiVersion.set(KotlinVersion.fromVersion(it)) }
        }
    }
}

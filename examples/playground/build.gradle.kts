import com.google.devtools.ksp.gradle.KspTaskJvm
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") apply false

}

subprojects {
    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    tasks.withType<KotlinCompilationTask<*>>().configureEach {
        if (this is KspTaskJvm) return@configureEach
        compilerOptions {
            getOverriddenKotlinLanguageVersion(project)?.also { languageVersion.set(KotlinVersion.valueOf(it)) }
            getOverriddenKotlinApiVersion(project)?.also { apiVersion.set(KotlinVersion.valueOf(it)) }
        }
    }
}

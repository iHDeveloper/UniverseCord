import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("net.md-5:bungeecord-api:1.16-R0.5-SNAPSHOT")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    withType<ShadowJar> {
        archiveBaseName.set("${rootProject.name}-${project.name}")
        archiveVersion.set(project.version as String)
        relocate("kotlin", "me.ihdeveloper.wallmc.plugin.proxy.internal.kotlin")
        relocate("org.intellij", "me.ihdeveloper.wallmc.plugin.proxy.internal.intellij")
        relocate("org.jetbrains", "me.ihdeveloper.wallmc.plugin.proxy.internal.jetbrains")
    }
}

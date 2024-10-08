import java.net.URI

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    `maven-publish`
}

group = "com.zenmo"
version = System.getenv("VERSION_TAG") ?: "dev"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
    }
    js(IR) {
        useEsModules()
        generateTypeScriptDefinitions()
        binaries.library()
        compilations["main"].packageJson {
            // hack hack hack
            types = "kotlin/zero-zummon.d.ts"
        }
        browser {
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${libs.versions.kotlinx.serialization.json.get()}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${libs.versions.kotlinx.serialization.json.get()}")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
                implementation("com.benasher44:uuid:0.8.4")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

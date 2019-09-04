import org.gradle.internal.impldep.org.apache.maven.Maven

plugins {
    kotlin("multiplatform")
    `maven-publish`
}


repositories {
    mavenCentral()
}

kotlin {
    targets {
        jvm()
        js {
            browser()
            nodejs()
        }
        linuxX64()
        linuxArm32Hfp()
        macosX64()
        mingwX64()
        iosArm64()
        iosArm32()
        iosX64()
    }
    sourceSets {
        commonTest {
            kotlin.srcDir("src/test/kotlin")
        }
    }
}

dependencies {
    commonMainImplementation("org.jetbrains.kotlin:kotlin-stdlib")
    commonTestImplementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
    commonTestImplementation("org.jetbrains.kotlin:kotlin-test-common")

    "jvmMainImplementation"("org.jetbrains.kotlin:kotlin-stdlib")
    "jvmTestImplementation"("org.jetbrains.kotlin:kotlin-test-junit")

    "jsMainImplementation"("org.jetbrains.kotlin:kotlin-stdlib-js")
    "jsTestImplementation"("org.jetbrains.kotlin:kotlin-test-js")
}
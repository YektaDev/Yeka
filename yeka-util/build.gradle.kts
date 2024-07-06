import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinMultiplatform)
  id("module.publication")
}

kotlin {
  applyDefaultHierarchyTemplate()

  jvm()

  androidTarget {
    publishLibraryVariants("release")
    compilations.all {
      kotlinOptions.jvmTarget = "1.8"
    }
  }

  iosX64()
  iosArm64()
  iosSimulatorArm64()

  linuxX64()
  linuxArm64()

  macosX64()
  macosArm64()

  tvosArm64()
  tvosX64()
  tvosSimulatorArm64()

  watchosArm32()
  watchosArm64()
  watchosX64()
  watchosSimulatorArm64()
  watchosDeviceArm64()

  js()
  @OptIn(ExperimentalWasmDsl::class) wasmWasi()
  @OptIn(ExperimentalWasmDsl::class) wasmJs()

  sourceSets {
    val commonMain by getting {
    }

    val commonTest by getting {
      dependencies {
        implementation(libs.kotlin.test)
      }
    }

    val javaMain by creating {
      dependsOn(commonMain)
    }

    jvmMain.get().dependsOn(javaMain)
    androidMain.get().dependsOn(javaMain)
  }
}

android {
  namespace = "dev.yekta.yeka.util"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
}

/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinMultiplatform)
  id("module.publication")
}

val optIn = listOf(
  "kotlin.js.ExperimentalJsExport",
)

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

  js(IR) {
    browser()
    nodejs()
    binaries.library()
    binaries.executable()
  }

  sourceSets {
    all {
      optIn.forEach(languageSettings::optIn)
    }

    val commonMain by getting {
      dependencies {
        implementation(libs.ksoup.entities)
      }
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
  namespace = "dev.yekta.yeka.email.html"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
}

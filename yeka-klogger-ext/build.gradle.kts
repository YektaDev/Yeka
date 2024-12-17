/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

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

  js(IR) {
    browser()
    nodejs()
    binaries.library()
    binaries.executable()
  }

  // @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class) wasmWasi()
  @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class) wasmJs()

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(project(":yeka-util"))
        implementation(libs.kotlin.logging)
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
  namespace = "dev.yekta.yeka.klogger.ext"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
}

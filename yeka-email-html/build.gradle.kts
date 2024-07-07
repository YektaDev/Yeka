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
      dependencies {
        implementation(libs.apache.commons.text)
      }
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

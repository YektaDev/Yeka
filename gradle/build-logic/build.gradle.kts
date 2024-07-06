/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  `kotlin-dsl`
}

repositories {
  google()
  mavenCentral()
  maven("https://plugins.gradle.org/m2/")
}

dependencies {
  implementation(libs.nexus.publish)
}

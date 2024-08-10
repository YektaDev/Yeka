/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  id("root.publication")
  alias(libs.plugins.androidLibrary) apply false
  alias(libs.plugins.kotlinMultiplatform) apply false
  id("dev.petuska.npm.publish") version "3.4.3" apply false
}

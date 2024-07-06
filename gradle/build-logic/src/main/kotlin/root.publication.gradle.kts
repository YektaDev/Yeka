/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  id("io.github.gradle-nexus.publish-plugin")
}

allprojects {
  group = "dev.yekta.yeka"
  version = "0.0.1"
}

nexusPublishing {
  // Configure maven central repository
  // https://github.com/gradle-nexus/publish-plugin#publishing-to-maven-central-via-sonatype-ossrh
  repositories {
    sonatype { // For users registered in Sonatype after 24 Feb 2021
      nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
      snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
    }
  }
}

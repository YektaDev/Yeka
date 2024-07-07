/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  `maven-publish`
  signing
}

publishing {
  publications.withType<MavenPublication> {
    // Stub javadoc.jar artifact
    artifact(
      tasks.register("${name}JavadocJar", Jar::class) {
        archiveClassifier.set("javadoc")
        archiveAppendix.set(this@withType.name)
      },
    )
    repositories {
      maven {
        // TODO: Setup the repository
      }
    }
    pom {
      name.set("Yeka Libraries")
      description.set("A collection of Kotlin Multiplatform libraries.")
      url.set("https://github.com/YektaDev/Yeka")
      licenses {
        license {
          name.set("Apache-2.0")
          url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
        }
      }
      issueManagement {
        system.set("Github")
        url.set("https://github.com/YektaDev/Yeka/issues")
      }
      developers {
        developer {
          id.set("YektaDev")
          name.set("Ali Khaleqi Yekta")
          email.set("me@yekta.dev")
          organization.set("Yeka")
          organizationUrl.set("https://www.yekta.dev")
        }
      }
      scm {
        url.set("https://github.com/YektaDev/Yeka")
        connection.set("scm:git://github.com/YektaDev/Yeka.git")
        developerConnection.set("scm:git://github.com/YektaDev/Yeka.git")
      }
    }
  }
}

signing {
  if (project.hasProperty("signing.gnupg.keyName")) {
    useGpgCmd()
    sign(publishing.publications)
  }
}

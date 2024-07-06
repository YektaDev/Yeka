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

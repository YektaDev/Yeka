rootProject.name = "Yeka"

pluginManagement {
  includeBuild("gradle/build-logic")
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  @Suppress("UnstableApiUsage")
  repositories {
    google()
    mavenCentral()
  }
}

include(
  ":yeka-log",
  ":yeka-util",
)

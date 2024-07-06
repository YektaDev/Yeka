/*
 * Unpublished Copyright 2022-2023 Ali Khaleqi Yekta, All Rights Reserved.
 */

package dev.yekta.yeka.log

import kotlin.jvm.JvmField

class LoggerConfig(
  @JvmField val minSeverity: LogSeverity = LogSeverity.VERBOSE,
  @JvmField val writers: List<LogWriter> = listOf(platformLogWriter()),
) {
  override fun hashCode(): Int = minSeverity.ordinal * 31 + writers.hashCode()
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is LoggerConfig) return false
    return minSeverity == other.minSeverity && writers == other.writers
  }
}

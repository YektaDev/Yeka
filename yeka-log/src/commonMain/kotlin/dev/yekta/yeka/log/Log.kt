/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

import dev.yekta.yeka.log.LogMessageTransformer.Companion.Identity
import dev.yekta.yeka.log.LogSeverity.ASSERT
import dev.yekta.yeka.log.LogSeverity.ERROR
import dev.yekta.yeka.log.LogSeverity.INFO
import dev.yekta.yeka.log.LogSeverity.VERBOSE
import dev.yekta.yeka.log.LogSeverity.WARN
import dev.yekta.yeka.util.fastForEach

data class Log(
  override val config: LoggerConfig,
  override val transformer: LogMessageTransformer = Identity,
) : Logger {
  override fun push(severity: LogSeverity, message: String, input: Any?) {
    config.writers.fastForEach { if (it.isLoggable(severity)) it.log(severity, message, input) }
  }

  /** ## Logs with [VERBOSE] severity. */
  inline fun v(message: String, inputs: Any? = null) {
    if (config.minSeverity <= VERBOSE) push(VERBOSE, transformer(message), inputs)
  }

  /** ## Logs with [INFO] severity. */
  inline fun i(message: String, inputs: Any? = null) {
    if (config.minSeverity <= INFO) push(INFO, transformer(message), inputs)
  }

  /** ## Logs with [WARN] severity. */
  inline fun w(message: String, inputs: Any? = null) {
    if (config.minSeverity <= WARN) push(WARN, transformer(message), inputs)
  }

  /** ## Logs with [ERROR] severity. */
  inline fun e(message: String, inputs: Any? = null) {
    if (config.minSeverity <= ERROR) push(ERROR, transformer(message), inputs)
  }

  /**
   * # What a Terrible Failure!
   * ## Logs with [ASSERT] severity.
   */
  inline fun wtf(message: String, inputs: Any? = null) = push(ASSERT, transformer(message), inputs)

  /** ## Logs with [VERBOSE] severity. */
  inline fun v(message: String, inputs: () -> Any) {
    if (config.minSeverity <= VERBOSE) push(VERBOSE, transformer(message), inputs())
  }

  /** ## Logs with [INFO] severity. */
  inline fun i(message: String, inputs: () -> Any) {
    if (config.minSeverity <= INFO) push(INFO, transformer(message), inputs())
  }

  /** ## Logs with [WARN] severity. */
  inline fun w(message: String, inputs: () -> Any) {
    if (config.minSeverity <= WARN) push(WARN, transformer(message), inputs())
  }

  /** ## Logs with [ERROR] severity. */
  inline fun e(message: String, inputs: () -> Any) {
    if (config.minSeverity <= ERROR) push(ERROR, transformer(message), inputs())
  }

  /**
   * # What a Terrible Failure!
   * ## Logs with [ASSERT] severity.
   */
  inline fun wtf(message: String, inputs: () -> Any) = push(ASSERT, transformer(message), inputs())
}

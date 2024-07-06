/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

actual fun platformLogWriter(formatter: LogFormatter): LogWriter = object : LogWriter {
  override fun log(severity: LogSeverity, message: String, input: Any?) {
    val log = formatter.format(severity, message, input)
    when(severity) {
      LogSeverity.VERBOSE -> console.log(log)
      LogSeverity.INFO -> console.info(log)
      LogSeverity.WARN -> console.warn(log)
      LogSeverity.ERROR -> console.error(log)
      LogSeverity.ASSERT -> console.error(log)
    }
  }
}

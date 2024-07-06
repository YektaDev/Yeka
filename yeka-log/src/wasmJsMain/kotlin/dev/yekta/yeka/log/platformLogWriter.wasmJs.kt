/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

actual fun platformLogWriter(formatter: LogFormatter): LogWriter = object : LogWriter {
  override fun log(severity: LogSeverity, message: String, input: Any?) {
    val log = formatter.format(severity, message, input)
    when (severity) {
      LogSeverity.VERBOSE -> consoleLog(log)
      LogSeverity.INFO -> consoleInfo(log)
      LogSeverity.WARN -> consoleWarn(log)
      LogSeverity.ERROR -> consoleError(log)
      LogSeverity.ASSERT -> consoleError(log)
    }
  }
}

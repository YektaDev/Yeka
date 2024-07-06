/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

import dev.yekta.yeka.log.LogSeverity.ASSERT
import dev.yekta.yeka.log.LogSeverity.ERROR
import dev.yekta.yeka.log.LogSeverity.INFO
import dev.yekta.yeka.log.LogSeverity.VERBOSE
import dev.yekta.yeka.log.LogSeverity.WARN
import dev.yekta.yeka.log.util.DefaultInputsFormatter

/**
 * A [LogFormatter] that formats logs without colors. This is a suitable formatter for production
 * and uses pragmatic defaults.
 */
object PlainLogFormatter : LogFormatter {
  override fun format(severity: LogSeverity, message: String, input: Any?): String {
    val s = when (severity) {
      VERBOSE -> "VRB"
      INFO -> "INF"
      WARN -> "WRN"
      ERROR -> "ERR"
      ASSERT -> "WTF"
    }
    return when (input) {
      null -> "$s $message"
      else -> "$s $message ${DefaultInputsFormatter.format(input)}"
    }
  }
}

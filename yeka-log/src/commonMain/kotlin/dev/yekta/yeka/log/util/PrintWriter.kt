/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log.util

import dev.yekta.yeka.log.LogFormatter
import dev.yekta.yeka.log.LogSeverity
import dev.yekta.yeka.log.LogWriter

internal class PrintWriter(private val formatter: LogFormatter) : LogWriter {
  override fun log(severity: LogSeverity, message: String, input: Any?) {
    println(formatter.format(severity, message, input))
  }
}

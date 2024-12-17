/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log.util

import dev.yekta.yeka.log.LogFormatter
import dev.yekta.yeka.log.LogSeverity
import dev.yekta.yeka.log.LogSeverity.ASSERT
import dev.yekta.yeka.log.LogSeverity.ERROR
import dev.yekta.yeka.log.LogSeverity.INFO
import dev.yekta.yeka.log.LogSeverity.VERBOSE
import dev.yekta.yeka.log.LogSeverity.WARN
import dev.yekta.yeka.util.contentToString

internal object ColoredPrintLogFormatter : LogFormatter {
  private const val RESET = "\u001b[0m"
  private const val WHITE = "\u001b[1;97m"
  private const val CYAN = "\u001b[1;96m"
  private const val YELLOW = "\u001b[1;93m"
  private const val RED = "\u001b[1;91m"
  private const val PURPLE = "\u001b[1;95m"
  private const val BLACK_BACK = "\u001b[40m"

  override fun format(severity: LogSeverity, message: String, input: Any?): String {
    val s = when (severity) {
      VERBOSE -> "${WHITE}VRB$RESET $WHITE"
      INFO -> "${CYAN}INF$RESET $CYAN"
      WARN -> "${YELLOW}WRN$RESET $YELLOW"
      ERROR -> "${RED}ERR$RESET $RED"
      ASSERT -> "${PURPLE}WTF$RESET $PURPLE"
    }
    return when (input) {
      null -> "$BLACK_BACK$s$message$RESET"
      else -> "$BLACK_BACK$s$message <${input.contentToString()}>$RESET"
    }
  }
}

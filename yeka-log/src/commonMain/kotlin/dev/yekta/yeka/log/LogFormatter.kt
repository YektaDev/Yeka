/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

fun interface LogFormatter {
  fun format(severity: LogSeverity, message: String, input: Any?): String
}

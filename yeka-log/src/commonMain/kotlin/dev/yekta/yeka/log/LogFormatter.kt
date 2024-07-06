/*
 * Unpublished Copyright 2022-2023 Ali Khaleqi Yekta, All Rights Reserved.
 */

package dev.yekta.yeka.log

fun interface LogFormatter {
  fun format(severity: LogSeverity, message: String, input: Any?): String
}

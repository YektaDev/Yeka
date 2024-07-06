/*
 * Unpublished Copyright 2022-2023 Ali Khaleqi Yekta, All Rights Reserved.
 */

package dev.yekta.yeka.log

interface LogWriter {
  fun isLoggable(severity: LogSeverity): Boolean = true
  fun log(severity: LogSeverity, message: String, input: Any?)
}

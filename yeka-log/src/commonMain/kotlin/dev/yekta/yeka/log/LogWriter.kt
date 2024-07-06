/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

interface LogWriter {
  fun isLoggable(severity: LogSeverity): Boolean = true
  fun log(severity: LogSeverity, message: String, input: Any?)
}

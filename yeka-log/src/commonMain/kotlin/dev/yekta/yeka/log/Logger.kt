/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

interface Logger {
  val config: LoggerConfig
  val transformer: LogMessageTransformer get() = LogMessageTransformer.Identity

  fun push(severity: LogSeverity, message: String, input: Any?)
}

/*
 * Unpublished Copyright 2022-2023 Ali Khaleqi Yekta, All Rights Reserved.
 */

package dev.yekta.yeka.log

interface Logger {
  val config: LoggerConfig
  val transformer: LogMessageTransformer get() = LogMessageTransformer.Identity

  fun push(severity: LogSeverity, message: String, input: Any?)
}

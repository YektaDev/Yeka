/*
 * Unpublished Copyright 2022-2023 Ali Khaleqi Yekta, All Rights Reserved.
 */

package dev.yekta.yeka.log

expect fun platformLogWriter(formatter: LogFormatter = debugLogFormatter()): LogWriter

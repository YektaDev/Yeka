/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

expect fun platformLogWriter(formatter: LogFormatter = debugLogFormatter()): LogWriter

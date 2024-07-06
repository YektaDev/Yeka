/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

import dev.yekta.yeka.log.util.PrintWriter

actual fun platformLogWriter(formatter: LogFormatter): LogWriter = PrintWriter(formatter)

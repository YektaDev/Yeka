/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

import dev.yekta.yeka.log.util.ColoredPrintLogFormatter

/**
 * Returns a [LogFormatter] that formats logs with colors when possible. This is only suitable for
 * debugging purposes while targeting platform's [LogWriter]. It also falls back to
 * [PlainLogFormatter] on the platforms that don't support colored logs (e.g., Android).
 */
actual fun debugLogFormatter(): LogFormatter = ColoredPrintLogFormatter

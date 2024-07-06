/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

import kotlin.jvm.JvmField

/*
 * IMPORTANT IMPLEMENTATION NOTES:
 *
 * + Do NOT re-order the enum values since the severity check is done by comparing the ordinal
 *   values.
 *
 * + Do NOT add a new severity below ASSERT, unless you've added a severity check before logging
 *   ASSERT.
 *
 */

enum class LogSeverity {
  @JvmField VERBOSE,
  @JvmField INFO,
  @JvmField WARN,
  @JvmField ERROR,
  @JvmField ASSERT,
}

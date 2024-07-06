/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

import kotlin.jvm.JvmField

fun interface LogMessageTransformer {
  operator fun invoke(message: String): String

  companion object {
    @JvmField
    val Identity = LogMessageTransformer { it }
  }
}

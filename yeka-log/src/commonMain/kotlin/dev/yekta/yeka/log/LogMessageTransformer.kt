/*
 * Unpublished Copyright 2022-2023 Ali Khaleqi Yekta, All Rights Reserved.
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

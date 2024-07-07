/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.email.html

import org.apache.commons.text.StringEscapeUtils.escapeHtml4

actual fun String.escapeHtml(): String = escapeHtml4(this)
  ?: throw IllegalArgumentException("Apache escapeHtml4 returned null for: $this")

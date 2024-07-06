/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log.util

import dev.yekta.yeka.log.LoggerConfig
import dev.yekta.yeka.log.Log

@Suppress("DeprecatedCallableAddReplaceWith")
@Deprecated(
  "Just a deprecation warning to remember this logger is purely meant for quick trial and error " +
    "purposes of the development phase and is NOT intended to be shipped to production!",
)
val Lg get() = Log(LoggerConfig())

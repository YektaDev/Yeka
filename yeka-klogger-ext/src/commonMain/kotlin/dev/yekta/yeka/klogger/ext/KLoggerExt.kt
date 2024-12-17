/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

@file:Suppress("unused")

import dev.yekta.yeka.util.contentToString
import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KMarkerFactory
import io.github.oshai.kotlinlogging.KotlinLogging

@Suppress("NOTHING_TO_INLINE")
inline fun logger() = KotlinLogging.logger {}

val wtfMarker = KMarkerFactory.getMarker("WTF")

/** ## Logs a debug message. */
inline fun KLogger.d(e: Throwable? = null, crossinline message: () -> Any) =
  debug(e) { message().contentToString() }

/** ## Logs an info. */
inline fun KLogger.i(e: Throwable? = null, crossinline message: () -> Any) =
  info(e) { message().contentToString() }

/** ## Logs a warning. */
inline fun KLogger.w(e: Throwable? = null, crossinline message: () -> Any) =
  warn(e) { message().contentToString() }

/** ## Logs an error. */
inline fun KLogger.e(e: Throwable? = null, crossinline message: () -> Any) =
  error(e) { message().contentToString() }

/**
 * # What a Terrible Failure!
 * For states that shouldn't be.
 */
inline fun KLogger.wtf(e: Throwable? = null, crossinline message: () -> Any) =
  error(e, wtfMarker) { message().contentToString() }

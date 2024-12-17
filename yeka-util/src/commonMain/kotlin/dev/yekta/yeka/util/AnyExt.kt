/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

@file:Suppress("unused")

package dev.yekta.yeka.util

private const val TR = "…"
private const val MAX_COUNT = 100
private const val MAX_DEPTH = 3
private const val MAX_CHARS = 50000

fun Any?.contentToStringUnlimited(): String = formatUnlimited(this)
fun Any?.contentToString(): String {
  val str = format(this)
  return when (str.length <= MAX_CHARS) {
    true -> str
    false -> str.substring(0, MAX_CHARS) + TR
  }
}

private fun format(input: Any?, i: Int = 0): String = with(input) {
  if (i >= MAX_DEPTH) return toString()
  return when (this) {
    null -> "null"
    is String -> this
    is Throwable -> stackTraceToString()
    is Set<*> -> joinToString(",", "{", "}", MAX_COUNT, TR) { format(it, i + 1) }
    is Collection<*> -> joinToString(",", "[", "]", MAX_COUNT, TR) { format(it, i + 1) }
    is Map.Entry<*, *> -> "${format(key, i + 1)}: ${format(value, i + 1)}"
    is Pair<*, *> -> "(${format(first, i + 1)}, ${format(second, i + 1)})"
    is Triple<*, *, *> -> "(${format(first, i + 1)}, ${format(second, i + 1)}, ${format(third, i + 1)})"
    is Array<*> -> joinToString(",", "(", ")", MAX_COUNT, TR) { format(it, i + 1) }
    is IntArray -> joinToString(",", "(", ")", MAX_COUNT, TR)
    is ByteArray -> joinToString(",", "(", ")", MAX_COUNT, TR)
    is FloatArray -> joinToString(",", "(", ")", MAX_COUNT, TR)
    is CharArray -> joinToString(",", "(", ")", MAX_COUNT, TR)
    is BooleanArray -> joinToString(",", "(", ")", MAX_COUNT, TR)
    is DoubleArray -> joinToString(",", "(", ")", MAX_COUNT, TR)
    is LongArray -> joinToString(",", "(", ")", MAX_COUNT, TR)
    is ShortArray -> joinToString(",", "(", ")", MAX_COUNT, TR)
    else -> toString()
  }
}

private fun formatUnlimited(input: Any?): String = with(input) {
  when (this) {
    null -> "null"
    is String -> this
    is Throwable -> stackTraceToString()
    is Set<*> -> joinToString(",", "{", "}") { formatUnlimited(it) }
    is Collection<*> -> joinToString(",", "[", "]") { formatUnlimited(it) }
    is Map.Entry<*, *> -> "${formatUnlimited(key)}: ${formatUnlimited(value)}"
    is Pair<*, *> -> "(${formatUnlimited(first)}, ${formatUnlimited(second)})"
    is Triple<*, *, *> -> "(${formatUnlimited(first)}, ${formatUnlimited(second)}, ${formatUnlimited(third)})"
    is Array<*> -> joinToString(",", "(", ")") { formatUnlimited(it) }
    is IntArray -> joinToString(",", "(", ")")
    is ByteArray -> joinToString(",", "(", ")")
    is FloatArray -> joinToString(",", "(", ")")
    is CharArray -> joinToString(",", "(", ")")
    is BooleanArray -> joinToString(",", "(", ")")
    is DoubleArray -> joinToString(",", "(", ")")
    is LongArray -> joinToString(",", "(", ")")
    is ShortArray -> joinToString(",", "(", ")")
    else -> toString()
  }
}

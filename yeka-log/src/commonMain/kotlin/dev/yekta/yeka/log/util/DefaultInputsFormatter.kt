package dev.yekta.yeka.log.util

internal object DefaultInputsFormatter {
  private const val TR = "…"
  private const val MAX_COUNT = 100
  private const val MAX_DEPTH = 3
  private const val MAX_CHARS = 50000

  fun format(input: Any): String {
    val str = formatI(input)
    return when (str.length <= MAX_CHARS) {
      true -> "<$str>"
      false -> "<${str.substring(0, MAX_CHARS)}$TR>"
    }
  }

  private fun formatI(input: Any?, i: Int = 0): String = with(input) {
    if (i >= MAX_DEPTH) return toString()
    return when (this) {
      null -> "null"
      is String -> this
      is Throwable -> stackTraceToString()
      is Set<*> -> joinToString(",", "{", "}", MAX_COUNT, TR) { formatI(it, i + 1) }
      is Collection<*> -> joinToString(",", "[", "]", MAX_COUNT, TR) { formatI(it, i + 1) }
      is Map.Entry<*, *> -> "${formatI(key, i + 1)}: ${formatI(value, i + 1)}"
      is Pair<*, *> -> "(${formatI(first, i + 1)}, ${formatI(second, i + 1)})"
      is Triple<*, *, *> -> "(${formatI(first, i + 1)}, ${formatI(second, i + 1)}, ${formatI(third, i + 1)})"
      is Array<*> -> joinToString(",", "(", ")", MAX_COUNT, TR) { formatI(it, i + 1) }
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
}

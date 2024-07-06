package dev.yekta.yeka.log

actual fun platformLogWriter(formatter: LogFormatter): LogWriter = object : LogWriter {
  override fun log(severity: LogSeverity, message: String, input: Any?) {
    println(formatter.format(severity, message, input))
  }
}

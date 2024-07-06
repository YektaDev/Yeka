package dev.yekta.yeka.log

import dev.yekta.yeka.log.util.PrintWriter

actual fun platformLogWriter(formatter: LogFormatter): LogWriter = PrintWriter(formatter)

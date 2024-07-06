/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

import dev.yekta.yeka.log.LogSeverity.ASSERT
import dev.yekta.yeka.log.LogSeverity.ERROR
import dev.yekta.yeka.log.LogSeverity.INFO
import dev.yekta.yeka.log.LogSeverity.VERBOSE
import dev.yekta.yeka.log.LogSeverity.WARN
import android.util.Log

actual fun platformLogWriter(formatter: LogFormatter): LogWriter = object : LogWriter {
  override fun log(severity: LogSeverity, message: String, input: Any?) {
    val log = formatter.format(severity, message, input)
    when (severity) {
      VERBOSE -> Log.v("YekaLog", log)
      INFO -> Log.i("YekaLog", log)
      WARN -> Log.w("YekaLog", log)
      ERROR -> Log.e("YekaLog", log)
      ASSERT -> Log.wtf("YekaLog", log)
    }
  }
}

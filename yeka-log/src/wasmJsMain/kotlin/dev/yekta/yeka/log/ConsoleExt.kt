/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.log

@JsFun("(message) => console.log(message)")
internal external fun consoleLog(message: String)

@JsFun("(message) => console.info(message)")
internal external fun consoleInfo(message: String)

@JsFun("(message) => console.warn(message)")
internal external fun consoleWarn(message: String)

@JsFun("(message) => console.error(message)")
internal external fun consoleError(message: String)

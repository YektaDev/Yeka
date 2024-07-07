/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.email.html

import com.mohamedrejeb.ksoup.entities.KsoupEntities

internal fun String.escapeHtml(): String = KsoupEntities.encodeHtml(this)

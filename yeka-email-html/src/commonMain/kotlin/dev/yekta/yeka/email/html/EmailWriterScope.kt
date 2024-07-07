/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.email.html

import org.intellij.lang.annotations.Language

sealed interface EmailHtmlWriterScope {
  fun String.escape(): String
  fun img(src: String, alt: String, width: Int, height: Int)
  fun img(src: String, alt: String, size: Int) = img(src, alt, size, size)
  fun primaryButton(label: String, href: String, inNewTab: Boolean = true)
  fun secondaryButton(label: String, href: String, inNewTab: Boolean = true)
  fun raw(@Language("HTML") html: String)
}

internal class EmailTemplateScopeImp : EmailHtmlWriterScope {
  @JvmField
  val output = StringBuilder(1024)

  override fun String.escape() = this.escapeHtml()

  override fun raw(@Language("HTML") html: String) {
    output.append(html)
  }

  @Language("HTML")
  private fun button(@Language("HTML") innerHtml: String, classes: String): String = """
  <table role="presentation" border="0" cellpadding="0" cellspacing="0" class="$classes">
    <tbody><tr><td align="center">
      <table role="presentation" border="0" cellpadding="0" cellspacing="0">
        <tbody><tr><td>$innerHtml</td></tr></tbody>
      </table>
    </td></tr></tbody>
  </table>
  """

  override fun primaryButton(label: String, href: String, inNewTab: Boolean) = raw(
    html = button(
      classes = "btn btn-primary",
      innerHtml = buildString(64) {
        append("<a href=\"${href.escape()}\"")
        if (inNewTab) append(" target=\"_blank\"")
        append(">${label.escape()}</a>")
      },
    ),
  )

  override fun secondaryButton(label: String, href: String, inNewTab: Boolean) = raw(
    html = button(
      classes = "btn",
      innerHtml = buildString(64) {
        append("<a href=\"${href.escape()}\"")
        if (inNewTab) append(" target=\"_blank\"")
        append(">${label.escape()}</a>")
      },
    ),
  )

  override fun img(src: String, alt: String, width: Int, height: Int) = raw(
    """<img src="${src.escape()}" alt="${alt.escape()}" width="$width" height="$height" border="0" style="border:0;outline:none;text-decoration:none;display:block;margin:0 auto;user-select:none;">""",
  )
}

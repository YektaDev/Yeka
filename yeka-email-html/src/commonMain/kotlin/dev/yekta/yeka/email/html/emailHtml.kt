/*
 * Copyright 2024 Ali Khaleqi Yekta, All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.yekta.yeka.email.html

import org.intellij.lang.annotations.Language

fun emailHtml(
  title: String,
  receiveReason: String,
  hiddenPreviewPrefix: String? = null,
  footerTopRow: EmailHtmlWriterScope.() -> Unit = {},
  footerBottomRow: EmailHtmlWriterScope.() -> Unit = {},
  @Language("CSS") extraStyle: String = "",
  body: EmailHtmlWriterScope.() -> Unit,
): String {
  return emailHtmlTemplate(
    titleEs = title.escapeHtml(),
    receiveReasonEs = receiveReason.escapeHtml(),
    hiddenPrefixEs = hiddenPreviewPrefix?.escapeHtml(),
    extraStyleSafe = extraStyle.also { require(!it.contains("</")) { "Extra style contains a closing tag!" } },
    body = EmailTemplateScopeImp().also(body).output.toString(),
    footerTopRow = EmailTemplateScopeImp().also(footerTopRow).output.toString(),
    footerBottomRow = EmailTemplateScopeImp().also(footerBottomRow).output.toString(),
  )
}

@Language("HTML")
private fun emailHtmlTemplate(
  titleEs: String,
  receiveReasonEs: String,
  hiddenPrefixEs: String?,
  @Language("CSS") extraStyleSafe: String,
  @Language("HTML") body: String,
  @Language("HTML") footerTopRow: String,
  @Language("HTML") footerBottomRow: String,
): String {
  val hiddenPreviewClass =
    "color:transparent;display:none;width:0;height:0;max-width:0;max-height:0;opacity:0;overflow:hidden;mso-hide:all;visibility:hidden"

  @Language("HTML")
  val html = """
  <!doctype html>
  <html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${titleEs}</title>
    <style media="all" type="text/css">
      body,table td{font-size:16px;font-family:system-ui,-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,Helvetica,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol"}body,hr{padding:0}table{width:100%}.content,hr{display:block}body,p,table td{font-family:system-ui,-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,Helvetica,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol"}.btn table td,.footer,.ignored{text-align:center}.btn a,.btn table td{background-color:#fff}.btn,.btn a,.content,.wrapper{box-sizing:border-box}::selection{color:#fff;background:#010f3c}::-moz-selection{color:#fff;background:#010f3c}body{background-color:#f4f5f6}body{-webkit-font-smoothing:antialiased;line-height:1.5;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%;margin:0}table{border-collapse:separate;mso-table-lspace:0;mso-table-rspace:0}table td{vertical-align:top}hr{height:1px;border:0;border-top:1px solid #eaeafa;margin:24px 0}.container{margin:0 auto!important;max-width:600px;padding:24px 0 0;width:600px}.btn,.footer,.main{width:100%}.content{margin:0 auto;max-width:600px;padding:0}.main{background:#fff;border:1px solid #eaeafa;border-radius:16px}.wrapper{padding:32px}.footer{clear:both;padding-top:24px}.footer a,.footer p,.footer span,.footer td{color:#9a9ea6;font-size:12px;text-align:center}.btn a,a{color:#010f3c}.btn a,p{font-size:16px}p{font-weight:400;margin:0 0 16px}a{text-decoration:underline}.mono{font-family:ui-monospace,Menlo,Monaco,"Cascadia Mono","Segoe UI Mono","Roboto Mono","Oxygen Mono","Ubuntu Monospace","Source Code Pro","Fira Mono","Droid Sans Mono","Courier New",monospace}.secondary{color:#5080f0}.ignored{color:#8a8ea6;font-size:14px}.btn{min-width:100%!important;user-select:none}.btn>tbody>tr>td{padding-bottom:16px}.btn table{width:auto}.btn table td{border-radius:4px}.btn a{border:2px solid #010f3c;border-radius:4px;cursor:pointer;display:inline-block;font-weight:700;margin:0;padding:12px 24px;text-decoration:none;text-transform:capitalize}.btn-primary a,.btn-primary table td{background-color:#010f3c}.btn-primary a{border-color:#010f3c;color:#fff}@media only screen and (max-width:640px){.btn a,.main p,.main span,.main td{font-size:16px!important}.btn a,.btn table{max-width:100%!important;width:100%!important}.btn a,.btn table,.container{width:100%!important}.wrapper{padding:8px!important}.content{padding:0!important}.container{padding:8px 0 0!important}.main{border-left-width:0!important;border-radius:0!important;border-right-width:0!important}}@media all{.btn-primary a:hover,.btn-primary table td:hover{background-color:#162d77!important}.btn-primary a:hover{border-color:#162d77!important}.ExternalClass{width:100%}.ExternalClass,.ExternalClass div,.ExternalClass font,.ExternalClass p,.ExternalClass span,.ExternalClass td{line-height:100%}.apple-link a{color:inherit!important;font-family:inherit!important;font-size:inherit!important;font-weight:inherit!important;line-height:inherit!important;text-decoration:none!important}#MessageViewBody a{color:inherit;text-decoration:none;font-size:inherit;font-family:inherit;font-weight:inherit;line-height:inherit}}
      $extraStyleSafe
    </style>
  </head>
  <body>
  <table role="presentation" border="0" cellpadding="0" cellspacing="0" style="background-color:#f4f5f6;width:100%;">
    <tr>
      <td>&nbsp;</td>
      <td class="container">
        <div class="content" style="line-height:1.5!important">
        ${if (hiddenPrefixEs != null) """<span style="$hiddenPreviewClass">$hiddenPrefixEs</span>""" else ""}
          <table role="presentation" border="0" cellpadding="0" cellspacing="0" class="main">
            <tr>
              <td class="wrapper" style="line-height:1.5!important">$body<hr/><p class="ignored">$receiveReasonEs</p></td>
            </tr>
          </table>
          <div class="footer">
            <table role="presentation" border="0" cellpadding="0" cellspacing="0">
              <tr><td><span class="apple-link">${footerTopRow}</span></td></tr>
              <tr><td style="padding:8px 0 0"><span class="apple-link">${footerBottomRow}</span></td></tr>
              <tr><td style="padding:24px 0;user-select:none"> &nbsp; </td></tr>
            </table>
          </div>
        </div>
      </td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </body>
  </html>
  """

  return html.lineSequence().filter(String::isNotBlank).joinToString(" ") { it.trim() }
}

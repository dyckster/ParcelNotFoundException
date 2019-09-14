package com.parcelnotfoundexception.javahack.util

import android.text.Html
import android.text.Spanned
import java.lang.ref.WeakReference
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun <T> T.weak() = WeakReference(this)

fun String.parseHtml(): Spanned =
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(this)
    }

fun String.parseDate(pattern: String = "dd.mm.yyyy"): Date {
    val format = SimpleDateFormat(pattern, Locale.ENGLISH)
    return format.parse(this)
}

fun Date.parseDate(pattern: String = "dd.mm.yyyy"): String {
    val format = SimpleDateFormat(pattern, Locale.ENGLISH)
    return format.format(this)
}

fun Int.separateThousands(): String {
    val formatter = NumberFormat.getInstance(Locale("RU")) as DecimalFormat
    val symbols = formatter.decimalFormatSymbols

    symbols.groupingSeparator = ' '
    formatter.decimalFormatSymbols = symbols
    return formatter.format(this)
}
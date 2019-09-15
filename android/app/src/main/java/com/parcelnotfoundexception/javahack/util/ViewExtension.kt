package com.parcelnotfoundexception.javahack.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.LayoutRes


fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

fun View.setVisibleOrGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.hide() {
    setVisibleOrGone(false)
}

fun View.show() {
    setVisibleOrGone(true)
}

fun View.fadeIn(duration: Long = 300) {
    animate().alpha(1F).duration = duration
}

fun View.fadeOut(duration: Long = 300) {
    animate().alpha(0F).duration = duration
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
}


fun Int.toDp(context: Context): Int = DipUtil.convertPixelsToDp(context, this.toFloat()).toInt()

fun Int.toPx(context: Context): Int = DipUtil.convertDpToPixel(context, this.toFloat()).toInt()

fun TextView.copyText() {
    val clipboard = this.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
    val clip = ClipData.newPlainText("ИНН", this.text)
    clipboard?.setPrimaryClip(clip)
}

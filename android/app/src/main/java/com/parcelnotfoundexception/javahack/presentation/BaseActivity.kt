package com.parcelnotfoundexception.javahack.presentation

import androidx.annotation.LayoutRes
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {

    @LayoutRes
    abstract fun layoutRes(): Int

}
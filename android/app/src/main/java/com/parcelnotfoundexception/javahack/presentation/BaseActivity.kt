package com.parcelnotfoundexception.javahack.presentation

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.arellomobile.mvp.MvpAppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        viewCreated()
    }

    @LayoutRes
    abstract fun layoutRes(): Int

    abstract fun viewCreated()

}
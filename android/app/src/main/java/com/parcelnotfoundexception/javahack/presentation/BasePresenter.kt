package com.parcelnotfoundexception.javahack.presentation

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<VIEW : MvpView> : MvpPresenter<VIEW>() {

    protected val disposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }


}
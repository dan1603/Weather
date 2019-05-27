package com.kalashnyk.denys.sweather.presentation.base

import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {

    override var view: WeakReference<V>? = null
    protected var compositeDisposable: CompositeDisposable? = null

    fun getView(): V? {
        return view!!.get()
    }

    override fun attachWithView(view: V) {
        this.view = WeakReference(view)
        compositeDisposable = CompositeDisposable()
    }

    override fun detachPresenter() {
        if (view != null && compositeDisposable != null) {
            compositeDisposable!!.clear()
            compositeDisposable = null
            view!!.clear()
            view = null
        }
    }

}
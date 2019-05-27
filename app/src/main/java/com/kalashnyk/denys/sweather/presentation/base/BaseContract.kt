package com.kalashnyk.denys.sweather.presentation.base

import java.lang.ref.WeakReference

interface BaseContract {

    interface View

    interface Presenter<V : BaseContract.View> {
        val view: WeakReference<V>?

        fun attachWithView(view: V)
        fun detachPresenter()
    }
}

package com.kalashnyk.denys.sweather.presentation.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kalashnyk.denys.sweather.App
import com.kalashnyk.denys.sweather.R
import com.kalashnyk.denys.sweather.di.component.PresenterComponent

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }

    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down)
    }

    protected abstract fun injectDependency(component: PresenterComponent)

    private fun createDaggerDependencies() {
        injectDependency((application as App).getPresenterComponent())
    }
}
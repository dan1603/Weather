package com.kalashnyk.denys.sweather.presentation.activities.splash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import com.kalashnyk.denys.sweather.R
import com.kalashnyk.denys.sweather.di.component.PresenterComponent
import com.kalashnyk.denys.sweather.presentation.base.BaseActivity
import javax.inject.Inject
import android.os.Looper
import com.kalashnyk.denys.sweather.databinding.SplashActivityBinding
import com.kalashnyk.denys.sweather.presentation.activities.main.MainActivity

class SplashActivity : BaseActivity(), SplashContract.View {

    var presenter: SplashContract.Presenter? = null
        @Inject set

    private val timer = 3000L
    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        presenter?.attachWithView(this)
        presenter?.getDefaultCityList(this)
    }

    override fun injectDependency(component: PresenterComponent) {
      component.inject(this)
    }

    override fun openMain() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(MainActivity.newInstance(this))
            finish()
        }, timer)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.detachPresenter()
    }
}

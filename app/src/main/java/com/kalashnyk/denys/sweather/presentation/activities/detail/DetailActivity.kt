package com.kalashnyk.denys.sweather.presentation.activities.detail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.kalashnyk.denys.sweather.R
import com.kalashnyk.denys.sweather.databinding.DetailActivityBinding
import com.kalashnyk.denys.sweather.di.component.PresenterComponent
import com.kalashnyk.denys.sweather.presentation.adapter.WeatherAdapter
import com.kalashnyk.denys.sweather.presentation.base.BaseActivity
import com.kalashnyk.denys.sweather.repository.model.WeatherData
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.ArrayList
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailContract.View {

    var presenter: DetailContract.Presenter? = null
        @Inject set

    lateinit var binding: DetailActivityBinding

    private lateinit var cityName: String

    companion object {
        @JvmStatic
        fun newInstance(context: Context, name: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(context.getString(R.string.EXTRAS_ID), name)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        presenter?.attachWithView(this)
        initActionBar()
        presenter?.getForecastByCityName(cityName)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.detachPresenter()
    }

    override fun injectDependency(component: PresenterComponent) {
        component.inject(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showContent(list: List<WeatherData>) {
        initRecyclerView(list)
        binding.progress.visibility = View.GONE
        binding.rvWeatherData.visibility = View.VISIBLE
    }

    override fun handlingEmptyOrErrorState(state: DetailContract.ContentState, error: String) {
        when (state) {
            DetailContract.ContentState.EMPTY -> binding.ivStateEmptyOrError.setImageResource(R.drawable.ic_empty_list)
            DetailContract.ContentState.ERROR -> {
                binding.ivStateEmptyOrError.setImageResource(R.drawable.ic_server_error)
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            }
        }
        binding.ivStateEmptyOrError.visibility = View.VISIBLE
        binding.progress.visibility = View.GONE
    }

    private fun initRecyclerView(list: List<WeatherData>) {
        rvWeatherData.layoutManager = LinearLayoutManager(this)
        rvWeatherData.adapter = WeatherAdapter(this, ArrayList(list))
    }

    private fun initActionBar() {
        cityName = intent.getStringExtra(getString(R.string.EXTRAS_ID))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = cityName
    }
}

package com.kalashnyk.denys.sweather.presentation.activities.main

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import com.kalashnyk.denys.sweather.R
import com.kalashnyk.denys.sweather.di.component.PresenterComponent
import com.kalashnyk.denys.sweather.presentation.adapter.CityAdapter
import com.kalashnyk.denys.sweather.presentation.base.BaseActivity
import com.kalashnyk.denys.sweather.repository.database.entity.CityEntity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.app.AlertDialog
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import com.kalashnyk.denys.sweather.databinding.MainActivityBinding
import java.util.ArrayList
import android.view.ViewGroup

class MainActivity : BaseActivity(), MainContract.View {

    var presenter: MainContract.Presenter? = null
        @Inject set

    lateinit var binding: MainActivityBinding
    lateinit var adapterCity : CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter?.attachWithView(this)
        presenter?.getListCities()
        initFab()
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    override fun injectDependency(component: PresenterComponent) {
        component.inject(this)
    }

    override fun showListCities(list: List<CityEntity>) {
        rvCities.layoutManager = LinearLayoutManager(this)
        var items = ArrayList(list)
        adapterCity = CityAdapter(this, items, this)
        rvCities.adapter = adapterCity
    }

    override fun updateList(city: CityEntity) {
        adapterCity.addItem(city)
    }

    override fun removeCity(city: CityEntity) {
        adapterCity.removeItem(city)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    private fun initFab() {
        fabAddCity.setOnClickListener {
            showAddingDialog()
        }
    }

    private fun showAddingDialog() {
        var taskEditText = EditText(this)
        taskEditText.setSingleLine()
        var container = FrameLayout(this)
        val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.leftMargin = resources.getDimensionPixelSize(R.dimen.indentation_18)
        params.rightMargin = resources.getDimensionPixelSize(R.dimen.indentation_18)
        taskEditText.layoutParams = params
        container.addView(taskEditText)
        val dialog = AlertDialog.Builder(this)
            .setTitle(R.string.new_dialog_title)
            .setMessage(R.string.new_dialog_message)
            .setView(container)
            .setPositiveButton(R.string.new_dialog_btn_positive) {
                    dialogInterface, i ->
                presenter?.addCity(taskEditText.text.toString())
            }
            .setNegativeButton(R.string.new_dialog_btn_negative, null)
            .create()
        dialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.detachPresenter()
    }

    fun deleteCity(name: String) {
        presenter?.removeCity(name)
    }
}

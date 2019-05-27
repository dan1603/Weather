package com.kalashnyk.denys.sweather.presentation.activities.detail

import com.kalashnyk.denys.sweather.presentation.base.BasePresenter
import com.kalashnyk.denys.sweather.repository.AppRepository
import com.kalashnyk.denys.sweather.utils.DataMapping

class DetailPresenter(val repository: AppRepository): BasePresenter<DetailContract.View>(), DetailContract.Presenter {

    override fun getForecastByCityName(name: String) {
        compositeDisposable?.add(repository.getForecastByCityName(name)?.subscribe { response ->
            if (response.isSuccessful) {
                val listContent = DataMapping.prepareData(response)
                if(listContent.isNotEmpty()) {
                    getView()?.showContent(listContent)
                }else{
                    getView()?.handlingEmptyOrErrorState(DetailContract.ContentState.EMPTY, "List is empty")
                }
            } else {
                var errorContent = DataMapping.parseBaseErrorResponse(response.errorBody()!!)
                getView()?.handlingEmptyOrErrorState(DetailContract.ContentState.ERROR, errorContent.message!!)
            }
        }!!)
    }
}
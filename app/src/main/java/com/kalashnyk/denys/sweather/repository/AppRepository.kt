package com.kalashnyk.denys.sweather.repository

import com.kalashnyk.denys.sweather.repository.database.AppDatabase
import com.kalashnyk.denys.sweather.repository.database.entity.CityEntity
import com.kalashnyk.denys.sweather.repository.server.ServerCommunicator
import com.kalashnyk.denys.sweather.utils.DataMapping
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

// we use parse inside repository layer for handling response
class AppRepository(private val serverCommunicator: ServerCommunicator, private val database: AppDatabase) {

    fun getForecastByCityName(name: String): Single<Response<ResponseBody>>? {
        return serverCommunicator.getForecastByCityName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun addDefaultCityList(list: List<String>): Completable {
        return Maybe.just(list)
            .map { return@map DataMapping.convertList(list) }
            .flatMapCompletable {
                Completable.fromAction { database.cityDao().insertList(it) }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
    }

    fun addCity(city: CityEntity): Completable {
        return Maybe.just(city)
            .flatMapCompletable {
                Completable.fromAction { database.cityDao().insert(it) }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun removeCity(city: CityEntity): Completable {
        return Maybe.just(city)
            .flatMapCompletable {
                Completable.fromAction { database.cityDao().delete(city) }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getListCities(): Single<List<CityEntity>> {
        return Single.just(database.cityDao().getAll())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
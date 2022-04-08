package kz.dev.marketplace_d.model.api

import io.reactivex.Single
import kz.dev.marketplace_d.model.response.Good
import kz.dev.marketplace_d.model.response.ResponseMainCustomer
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GoodsService {

    private val BASE_URL = "http://91.201.214.194/"
    private val api: GoodsApi

    init {
        api =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(GoodsApi::class.java)
    }


    fun getGoods(): Single<ResponseMainCustomer> {
        return api.getAllGoods()
    }
}
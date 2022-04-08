package kz.dev.marketplace_d.model.api

import io.reactivex.Single
import kz.dev.marketplace_d.model.response.Good
import kz.dev.marketplace_d.model.response.ResponseMainCustomer
import retrofit2.http.GET

interface GoodsApi {

    @GET("api/v1/products")
    fun getAllGoods(): Single<ResponseMainCustomer>
}
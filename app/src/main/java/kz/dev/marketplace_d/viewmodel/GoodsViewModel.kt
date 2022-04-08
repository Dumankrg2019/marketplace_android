package kz.dev.marketplace_d.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kz.dev.marketplace_d.model.api.GoodsService
import kz.dev.marketplace_d.model.response.Good
import kz.dev.marketplace_d.model.response.ResponseMainCustomer

class GoodsViewModel: ViewModel() {

    private val goodsService = GoodsService()
    private val disposable = CompositeDisposable()

    val goods = MutableLiveData<List<Good>>()
    val goodsLoadedError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchGoods()
    }

    private fun fetchGoods() {

        loading.value = true

        disposable.add(

            goodsService.getGoods()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<ResponseMainCustomer>()
                {

                    override fun onError(e: Throwable) {
                        goodsLoadedError.value = true
                        loading.value = false
                        Log.e("Network error", "${e.printStackTrace()}")
                    }

                    override fun onSuccess(t: ResponseMainCustomer) {
                        goods.value = t.data
                        goodsLoadedError.value = false
                        loading.value = false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}

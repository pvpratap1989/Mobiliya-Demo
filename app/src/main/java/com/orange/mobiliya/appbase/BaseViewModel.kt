package com.orange.mobiliya

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

abstract class BaseViewModel <N> : ViewModel() {

    lateinit var retrofit: Retrofit

    val isLoading = ObservableBoolean(false)

    var compositeDisposable: CompositeDisposable? = null
        private set

    var navigator: N? = null

    fun getmIsLoading(): ObservableBoolean {
        return isLoading
    }

    fun getmCompositeDisposable(): CompositeDisposable? {
        return compositeDisposable
    }

    fun setmCompositeDisposable(mCompositeDisposable: CompositeDisposable) {
        this.compositeDisposable = mCompositeDisposable
    }

    fun getmNavigator(): N? {
        return navigator
    }

    fun setmNavigator(mNavigator: N) {
        this.navigator = mNavigator
    }

    init {
        this.compositeDisposable = CompositeDisposable()
    }

    override fun onCleared() {
        compositeDisposable!!.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun setRetrofitClient(retrofit: Retrofit){
        this.retrofit = retrofit
    }

    fun getRetrofitClient(): Retrofit{
       return this.retrofit
    }


}

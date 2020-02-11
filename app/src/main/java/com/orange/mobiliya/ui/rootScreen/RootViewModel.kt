package com.orange.mobiliya.ui.rootScreen

import com.orange.mobiliya.BaseViewModel
import com.orange.mobiliya.Service.GitHubService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class RootViewModel : BaseViewModel<RootNavigator>() {

    var githubUserId: String = ""

    fun onSearchClick() {
        retrofit
            .create(GitHubService::class.java)
            .getUserProfile(githubUserId)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer {
                print("Error")
            })
            ?.subscribe(Consumer {
                it?.let { it1 -> getmNavigator()!!.onUserProficeRecived(it1) }
                //Get User Repos
                getUserRepos()
            }, Consumer { getmNavigator()?.onError("") })
    }

    fun getUserRepos() {
        retrofit
            .create(GitHubService::class.java)
            .getUserRepos(githubUserId)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer {
                print("Error")
            })
            ?.subscribe(Consumer {
                it?.let { it1 -> getmNavigator()!!.onUserRepoReceived(it1) }
            }, Consumer { getmNavigator()?.onError("") })
    }

}
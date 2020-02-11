package com.orange.mobiliya.Service

import com.orange.mobiliya.dataModels.UserProfile
import com.orange.mobiliya.dataModels.UserRepos
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {
    @GET("/users/{username}")
    fun getUserProfile(@Path("username") userName: String): Flowable<UserProfile?>?

    @GET("/users/{username}/repos")
    fun getUserRepos(@Path("username") userName: String): Flowable<List<UserRepos?>>?
}
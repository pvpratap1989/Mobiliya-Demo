package com.orange.mobiliya.ui.rootScreen

import com.orange.mobiliya.dataModels.UserProfile
import com.orange.mobiliya.dataModels.UserRepos

interface RootNavigator{
    fun onUserProficeRecived(userProfile: UserProfile)
    fun onUserRepoReceived(userRepos: List<UserRepos?>)
    fun onError(error:String)
}
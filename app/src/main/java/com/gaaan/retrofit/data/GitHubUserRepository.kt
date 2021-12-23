package com.gaaan.retrofit.data

import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {
    fun getUsersList(): Single<List<GitHubUser>>
    fun getUserInfo(login: String): Single<GitHubUser>
}
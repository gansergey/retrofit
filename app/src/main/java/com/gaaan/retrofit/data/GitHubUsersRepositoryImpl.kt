package com.gaaan.retrofit.data

import com.gaaan.retrofit.data.retrofit.GitHubApiFactory
import io.reactivex.rxjava3.core.Single

class GitHubUsersRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()

    override fun getUsersList() = gitHubApi.fetchUsers()

    override fun getUserInfo(login: String): Single<GitHubUser> =
        gitHubApi.fetchUserDataByLogin(login)
}


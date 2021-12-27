package com.gaaan.retrofit.data

import com.gaaan.retrofit.data.retrofit.GitHubApiFactory
import io.reactivex.rxjava3.core.Single

class GitHubUsersRepositoryImpl : GitHubUserRepository {

    private val gitHubUserDB = GitHubUserDBFactory.create().getGitHubUserDao()
    private val gitHubApi = GitHubApiFactory.create()

    override fun getUsersList(): Single<List<GitHubUser>> {
        return gitHubUserDB.getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            gitHubUserDB.saveUserToDB(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }
    override fun getUserInfo(login: String): Single<GitHubUser> =
        gitHubUserDB.getUserByLogin(login)

}


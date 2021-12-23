package com.gaaan.retrofit.data

object GitHubUsersRepositoryFactory {
    fun create(): GitHubUserRepository = GitHubUsersRepositoryImpl()
}
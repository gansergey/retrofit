package com.gaaan.retrofit.user

import com.gaaan.retrofit.data.GitHubUser
import com.gaaan.retrofit.data.GitHubUserRepository
import com.gaaan.retrofit.data.convertUserToUserDetail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val repository: GitHubUserRepository,
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        showUserData(userLogin)
    }

    private fun showUserData(userLogin: String) {
        repository.getUserInfo(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user: GitHubUser ->
                viewState.showUserDetail(convertUserToUserDetail(user))
            }, { error: Throwable ->
                viewState.showError(error.message.toString())
            })
    }

}
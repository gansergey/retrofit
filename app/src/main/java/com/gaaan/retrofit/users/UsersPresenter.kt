package com.gaaan.retrofit.users

import com.gaaan.retrofit.application.App.Companion.router
import com.gaaan.retrofit.data.GitHubUserRepository
import com.gaaan.retrofit.data.convertUserListToUserItemList
import com.gaaan.retrofit.user.UserScreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(private val repository: GitHubUserRepository) :
    MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        updateUsersList()
    }

    fun showUserFragment(login: String) {
        router.navigateTo(UserScreen(login))
    }

    private fun updateUsersList() {
        repository.getUsersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ usersList ->
                viewState.showUsers(convertUserListToUserItemList(usersList))
            }, { error: Throwable ->
                viewState.showError(error.message.toString())
            })
    }
}
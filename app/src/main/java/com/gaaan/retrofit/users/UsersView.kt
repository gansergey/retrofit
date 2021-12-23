package com.gaaan.retrofit.users

import com.gaaan.retrofit.data.GitHubUserListItem
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface UsersView : MvpView {
    fun showUsers(users: List<GitHubUserListItem>)
    fun showError(message: String)
}
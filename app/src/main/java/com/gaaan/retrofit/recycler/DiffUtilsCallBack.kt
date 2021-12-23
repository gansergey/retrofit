package com.gaaan.retrofit.recycler

import androidx.recyclerview.widget.DiffUtil
import com.gaaan.retrofit.data.GitHubUserListItem


class DiffUtilsCallBack(
    private val oldUsersList: List<GitHubUserListItem>,
    private val newUsersList: List<GitHubUserListItem>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldUsersList.size

    override fun getNewListSize() = newUsersList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldUsersList[oldItemPosition].id == newUsersList[newItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_, oldLogin) = oldUsersList[oldItemPosition]
        val (_, newLogin) = newUsersList[newItemPosition]
        return oldLogin == newLogin
    }
}
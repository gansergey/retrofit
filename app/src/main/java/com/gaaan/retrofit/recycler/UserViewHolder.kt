package com.gaaan.retrofit.recycler

import androidx.recyclerview.widget.RecyclerView
import com.gaaan.retrofit.data.GitHubUserListItem
import com.gaaan.retrofit.databinding.UserListItemBinding

class UserViewHolder(private val binding: UserListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(user: GitHubUserListItem, userClickListener: UsersAdapter.OnItemClickListener) {
        binding.userListItemName.text = user.login
        binding.root.setOnClickListener {
            userClickListener.onUserClick(user)
        }
    }
}
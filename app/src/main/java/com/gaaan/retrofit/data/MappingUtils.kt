package com.gaaan.retrofit.data

fun convertUserListToUserItemList(
    userList: List<GitHubUser>,
): List<GitHubUserListItem> {
    val userItemList = ArrayList<GitHubUserListItem>()
    for (user in userList) {
        userItemList.add(convertUserToUserItem(user))
    }
    return userItemList
}

fun convertUserToUserDetail(
    user: GitHubUser,
) = GitHubUserDetail(
    user.id,
    user.login,
    user.siteAdmin
)

private fun convertUserToUserItem(
    user: GitHubUser,
) = GitHubUserListItem(
    user.id,
    user.login,
)

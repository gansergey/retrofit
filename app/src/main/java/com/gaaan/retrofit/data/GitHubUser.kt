package com.gaaan.retrofit.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUser(
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("login")
    val login: String = "undefined",
    @SerializedName("site_admin")
    val siteAdmin: Boolean = false
) : Parcelable
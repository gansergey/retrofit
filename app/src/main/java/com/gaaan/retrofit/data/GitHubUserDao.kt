package com.gaaan.retrofit.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM gb_users")
    fun getUsers(): Single<List<GitHubUser>>

    @Query("SELECT * FROM gb_users WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun saveUserToDB(user: GitHubUser)

    @Insert(onConflict = REPLACE)
    fun saveUserToDB(users: List<GitHubUser>)

}
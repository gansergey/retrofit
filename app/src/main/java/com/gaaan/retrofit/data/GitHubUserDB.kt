package com.gaaan.retrofit.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GitHubUser::class], version = 1, exportSchema = false)
abstract class GitHubUserDB : RoomDatabase() {
    abstract fun getGitHubUserDao(): GitHubUserDao
}
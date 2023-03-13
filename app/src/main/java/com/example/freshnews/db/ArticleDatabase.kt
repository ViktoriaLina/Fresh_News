package com.example.freshnews.db


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.freshnews.models.Article

@Database(entities = [Article::class], version = 1, exportSchema = true)

@TypeConverters(Converters::class)

abstract class ArticleDatabase: RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
}
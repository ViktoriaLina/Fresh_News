package com.example.freshnews.repository

import com.example.freshnews.api.NewsAPI
import com.example.freshnews.db.ArticleDao
import com.example.freshnews.db.ArticleDatabase
import com.example.freshnews.models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    val db: ArticleDatabase,
    private val newsAPI: NewsAPI,
    private val articleDao: ArticleDao
) {
    suspend fun getTopNews(sources: String, pageNumber: Int) =     // запрос на популярные статьи
        newsAPI.getTopNews(sources, pageNumber)

    suspend fun getSearchNews(searchQuery: String, pageNumber: Int) =     // запрос на поиск статьи
        newsAPI.getSearchNews(searchQuery, pageNumber)

    suspend fun insert(article: Article) = db.getArticleDao().insert(article)    // вставить статью в БД

    fun getSavedNews() = db.getArticleDao().getAllArticles()     // получить сохраненные статьи из БД

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)    // удалить статью из БД

}
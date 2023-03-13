package com.example.freshnews.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshnews.models.Article
import com.example.freshnews.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: NewsRepository): ViewModel()  {

    // вставить статью в БД
    fun saveArticle(article: Article) = viewModelScope.launch {
        repository.insert(article)
    }
}
package com.example.freshnews.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshnews.models.Article
import com.example.freshnews.models.NewsResponse
import com.example.freshnews.repository.NewsRepository
import com.example.freshnews.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: NewsRepository): ViewModel(){

    init{
        getSavedNews()
    }

    // получить сохраненные статьи из БД
    fun getSavedNews() = repository.getSavedNews()

    // удалить статью из БД
    fun deleteArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteArticle(article)
    }

    // вставить статью в БД
    fun saveArticle(article: Article) = viewModelScope.launch {
        repository.insert(article)
    }
}
package com.example.freshnews.viewModels


import androidx.lifecycle.ViewModel
import com.example.freshnews.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel()
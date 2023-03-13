package com.example.freshnews.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshnews.models.NewsResponse
import com.example.freshnews.repository.NewsRepository
import com.example.freshnews.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    val topNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var page = 1

    init{
        getTopNews("lenta")
    }

    fun getTopNews(sources: String) = viewModelScope.launch {
        topNews.postValue(Resource.Loading())
        val response = repository.getTopNews(sources, page)
        topNews.postValue(handleTopNewsResponse(response))
    }

    private fun handleTopNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return Resource.Error(response.message())
    }
}
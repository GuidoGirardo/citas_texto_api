package com.damaris.arquitectura_mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damaris.arquitectura_mvvm.data.model.QuoteModel
import com.damaris.arquitectura_mvvm.data.model.QuotesProvider
import com.damaris.arquitectura_mvvm.domain.GetQuotesUseCase
import com.damaris.arquitectura_mvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)

        val result = getRandomQuoteUseCase()
        if(result !== null){
            quoteModel.postValue(result!!)
        }

        isLoading.postValue(false)
    }

}
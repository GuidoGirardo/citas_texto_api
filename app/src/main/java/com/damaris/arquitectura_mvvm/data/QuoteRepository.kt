package com.damaris.arquitectura_mvvm.data

import com.damaris.arquitectura_mvvm.data.model.QuoteModel
import com.damaris.arquitectura_mvvm.data.model.QuotesProvider
import com.damaris.arquitectura_mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuotesProvider) {

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}
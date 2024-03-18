package com.damaris.arquitectura_mvvm.domain

import com.damaris.arquitectura_mvvm.data.QuoteRepository
import com.damaris.arquitectura_mvvm.data.model.QuoteModel
import com.damaris.arquitectura_mvvm.data.model.QuotesProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuotesProvider) {
    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}
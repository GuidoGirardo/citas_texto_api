package com.damaris.arquitectura_mvvm.domain

import com.damaris.arquitectura_mvvm.data.QuoteRepository
import com.damaris.arquitectura_mvvm.data.model.QuoteModel
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository ) {
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}

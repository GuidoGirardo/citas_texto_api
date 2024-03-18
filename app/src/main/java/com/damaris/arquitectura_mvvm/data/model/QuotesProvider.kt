package com.damaris.arquitectura_mvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuotesProvider @Inject constructor() {

    var quotes: List<QuoteModel> = emptyList(

    /*
    companion object {

        fun random(): QuoteModel {
            val position = (0..1).random()
            return quote[position]
        }

        var quote = listOf<QuoteModel>(
            QuoteModel(
                quote = "quote1",
                author = "xd 1"
            ),
            QuoteModel(
                quote = "quote2",
                author = "xd 2"
            )
        )
    } */
}
package com.damaris.arquitectura_mvvm.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(@SerializedName("quote") val quote: String, @SerializedName("author") val author: String)

// acá se piden los datos al retrofit o room, esta vez lo sacamos del "QuotesProvider"
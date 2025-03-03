package com.cursokotlin.mvvm.domain.model

import com.cursokotlin.mvvm.data.database.entities.QuoteEntity
import com.cursokotlin.mvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)